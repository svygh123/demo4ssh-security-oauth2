package com.ndh.demo4ssh.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.CompoundName;
import javax.naming.InvalidNameException;
import javax.naming.Name;

/**
 * <code>StringHelper</code>封装了字符串的常用操作，提供了更加简洁的静态调用方式。
 * <p>例如：</p>
 * <p>
 * <hr><blockquote><pre>
 * String src;
 * ......
 * String name=StringHelper.convertString(src,"UTF-8","GBK");
 * </pre></blockquote><hr>
 * </p>
 * <p>
 * 假设src是UTF-8编码的字符串，则上述代码将src转换成GBK编码的字符串
 * </p>
 */
public final class StringHelper
{

    /**将GBK编码的字符串转换成iso8859-1编码方式
     * @param s GBK编码的字符串
     * @return iso8859-1编码的字符串
     */
    public static String getIsoString(String s)
    {
        return convertString(s,"GBK","iso_8859_1");
    }
    /**将iso8859-1编码的字符串转换成GBK编码方式
     * @param s iso8859-1编码的字符串
     * @return GBK编码的字符串
     */
//	-------------------------------------------------------------------------------
    public static String getGbString(String s)
    {
        return convertString(s,"iso_8859_1","GBK");
    }
//	-------------------------------------------------------------------------------
    /**将一种编码的字符串转换成另一种编码方式。
     * 如果指定的编码方式不被支持，则返回原字符串
     * @param s 欲进行编码转换的字符串
     * @param srcCharset 原字符串的编码
     * @param targetCharset 目标编码方式
     * @return 转换编码后的字符串
     *  
     */
    public static String convertString(String s,String srcCharset,String targetCharset)
    {
        try
        {   
            return s==null?null:new String(s.getBytes(srcCharset),targetCharset);//
        }
        catch(UnsupportedEncodingException e)
        {
            return s;
        }
    }
//	-------------------------------------------------------------------------------
    /**将指定的字符串解析成整数。
     * 如果解析失败则返回指定的缺省值。
     * @param s 欲解析的字符串
     * @param def 缺省值
     * @return 解析后的整数
     */
    public static int parseInt(String s,int def)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return def;
        }
    }
//	-------------------------------------------------------------------------------
	/**
	 * 将存在List中的字符串或者可转化为字符串的对象用连接符连接起来形成一个新的字符串。
	 * @param list 给定的List
	 * @param linkStr 连接符
	 * @return list中的对象转化为字符串后用连接符连接起来后的字符串，该字符串的首和尾不含连接符。
	 */
	public static String listToStr(List list,String linkStr)
	{   
		if (list.size()==0) return null;
		StringBuffer result=new StringBuffer(list.get(0).toString());
		for(int i=1;i<list.size();i++)
		{
		   result.append(linkStr);
		   result.append(list.get(i));
		}
		return  result.toString();
	}
	
	public static String arrayToStr(String[] arr,String linkStr)
	{   
		if (arr.length==0) return null;
		StringBuffer result=new StringBuffer(arr[0].toString());
		for(int i=1;i<arr.length;i++)
		{
		   result.append(linkStr);
		   result.append(arr[i]);
		}
		return  result.toString();
	}
	/**
	 * 将存在于Map对象Key中的字符串或者可以转化为字符串的对象用连接符连接起来形成一个新的字符串。
	 * @param map 给定的Map
	 * @param linkStr 连接符
	 * @return Map对象Key中的字符串或者可以转化为字符串的对象用连接符连接起来形成一个新的字符串，
	 *         该字符串的首和尾不含连接符。
	 */
	public static String mapKeyToStr(Map map,String linkStr)
	{
	   StringBuffer result=null;
	   Iterator iterator=map.keySet().iterator();
	   if (iterator.hasNext())
	   {
		  
		  result=new StringBuffer(iterator.next().toString());
	   }
	   else
	   {
	     return null;
	   }
	   
	   while(iterator.hasNext())
	   {
		  result.append(linkStr);
		  result.append(iterator.next().toString());
	   }
	   return result.toString();
	}	
	/**
	 * 将存在于Map对象Value中的字符串或者可以转化为字符串的对象用连接符连接起来形成一个新的字符串。 
	 * @param map 给定的Map
	 * @param linkStr 连接符
	 * @return Map对象Value中的字符串或者可以转化为字符串的对象用连接符连接起来形成一个新的字符串,
	 *         该字符串的首和尾不含连接符。
	 */
	public static String mapValueToStr(Map map,String linkStr)
	{
		StringBuffer result=null;
		Iterator iterator=map.values().iterator();
		 if (iterator.hasNext())
		 {
		  
			result=new StringBuffer(iterator.next().toString());
		 }
		 else
		 {
		   return null;
		 }
	   
		 while(iterator.hasNext())
		 {
			result.append(linkStr);
			result.append(iterator.next().toString());
		 }
		 return result.toString();
	}
	
//	-------------------------------------------------------------------------------
	/**
	 * 功能：返回给定重复次数的重复的字符串组成的字符串
	 * @param repeatStr 需要重复的字符串
	 * @param time 重复次数
	 * @return 
	 */
	  public static String repeat(String repeatStr, int time)
	  {
		 StringBuffer valueStr = new StringBuffer();
		 for (int i = 0; i < time; i++) 
		 {
			  valueStr.append(repeatStr);
		 }
		 return valueStr.toString();
	  }
//-------------------------------------------------------------------------------
  /**
	* 对给定的字符串提取其指纹信息，多用于身份识别。
	* @param algorithmName 不可逆的加密算法名称。
	* @param encryptString 被加密的字符串。
	* @return 加密后的字符串，16进制表示的字符串。
	* @throws Exception  
	* @throws UnsupportedEncodingException 不支持的编码方式时抛出的异常
	* @throws NoSuchAlgorithmException 无指定名称的加密算法支持时抛出的异常
	*/
   public static String getDigestFormStr(String algorithmName,String encryptString)throws Exception,UnsupportedEncodingException, NoSuchAlgorithmException
   {
	   byte[] encryptData=encryptString.getBytes("8859_1");
	   MessageDigest md = MessageDigest.getInstance( algorithmName );
	   md.update( encryptData );
	   byte[] digest = md.digest();
	   return byte2hex(digest,"");
   }
   
  

   /**
	* 清空StringBuffer中的内容。
	* @param strBuffer
	*/
   public static void clearStrBuffer(StringBuffer strBuffer)
   {
	   if (strBuffer==null) return;
	   if (strBuffer.length()==0) return;
	   strBuffer.delete(0,strBuffer.length());
   }
  /**
   * 将二进制字节转化为16进制表示的字符串。
   * @param b 二进制字节数组。
   * @param linkStr 每个16进制字符之间的分隔符。
   * @return 16进制表示的字符串。
   * @throws Exception
   */
	   public static String byte2hex(byte[] b,String linkStr) throws Exception{
		  String hs="";
		  String stmp="";
		  for (int n=0;n<b.length;n++)
		  {
			stmp=(java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length()==1) hs=hs+"0"+stmp;
			else hs=hs+stmp;
			if (n<b.length-1)  hs=hs+linkStr;
		  }
		 return hs.toUpperCase();
	   }
	   /**
	    * 将符合Java语言包名规范的字符串转化为对应的Name对象，以便获取上级包。
	    * @param n 给定的包名字符串
	    * @return  包的名字
	    * @throws InvalidNameException 参数字符串不符合Java语言包名规范则产生该异常。
	    */
	   public static Name strToJavaPackageName(String n) throws InvalidNameException
	   {
		   Properties syntax=new Properties ();
		   syntax.put("jndi.syntax.direction","left_to_right");
		   syntax.put("jndi.syntax.separator",".");
		   syntax.put("jndi.syntax.ignorecase","true");
		   syntax.put("jndi.syntax.trimblanks","true"); 
		   return new CompoundName(n,syntax);
	   }
	public static String setToStr(Set<String> set, String linkStr) {
		if (set.size()==0) return null;
		StringBuffer result = new StringBuffer();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			 result.append(linkStr);
			 result.append(iterator.next());
			
		}
		return  result.toString().substring(linkStr.length());
	}
}
