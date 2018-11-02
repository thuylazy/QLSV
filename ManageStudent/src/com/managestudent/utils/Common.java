/**
 * Copyright(C) K16SE Luvina
 *
 * Common.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.utils;

import java.lang.Math;
import java.lang.Character.UnicodeBlock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import managestudent.entities.Diem;
import managestudent.entities.MonHoc;

/**
 * Common
 *
 * @author HaVH
 *
 */
public class Common {

	/**
	 * Paging
	 *
	 * @param record_num
	 *            int
	 * @param record_per_page
	 *            int
	 * @param page_range
	 *            int
	 * @param url
	 *            String
	 * @param pageid
	 *            int
	 * @param f_name_js
	 *            String
	 * @return String paging
	 */
	public static String paging(int record_num, int record_per_page,
			int page_range, String url, int pageid, String f_name_js) {

		String separator = "";
		String pre_str = "&lsaquo;";
		String next_str = "&rsaquo;";
		String first_str = "&laquo;";
		String last_str = "&raquo;";

		if (record_per_page == 0) {
			return "";
		}

		String st = "";
		String cc;
		if (url.indexOf("?") > -1) {
			cc = "&";
		} else {
			cc = "?";
		}

		int page_num;
		page_num = (int) Math.ceil((double) record_num / record_per_page);

		pageid = (int) pageid;

		if (pageid < 1) {
			pageid = 1;
		}

		if (pageid > page_num) {
			pageid = page_num;
		}

		if (page_num < page_range) {
			page_range = page_num;
		}

		int division;
		int page_lim1 = 0;
		int page_lim2 = 0;

		if (page_range == 0) {
			division = 0;
		} else {
			division = (int) Math.floor(page_num / page_range);
		}

		for (int i = 0; i <= division; i++) {
			if (((i * page_range + 1) <= pageid)
					&& (((i + 1) * page_range) >= pageid)) {
				page_lim1 = i * page_range + 1;
				page_lim2 = page_lim1 + page_range - 1;
				if (page_lim2 > page_num) {
					page_lim2 = page_num;
				}
				break;
			}
		}

		String urlEncode = url;

		if (page_num > 1) {
			if (pageid > 1) {
				if (f_name_js.trim().compareTo("") != 0) {
					if (first_str.trim().compareTo("") != 0)
						st += " <a href='javascript:" + f_name_js + "(\""
								+ urlEncode + "\", 1)'  class='txtBlue'>"
								+ first_str + "</a>";
					if (pre_str.trim().compareTo("") != 0)
						st += separator + " <a href='javascript:" + f_name_js
								+ "(\"" + urlEncode + "\", " + (pageid - 1)
								+ ")' class='txtBlue'>" + pre_str + "</a> ";
				} else {
					if (first_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc
								+ "page=1&isBack=1' class='txtBlue'>"
								+ first_str + "&nbsp;</a>";
					if (pre_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc + "page=" + (pageid - 1)
								+ "&isBack=1' class='txtBlue'>" + pre_str
								+ "</a> ";
				}
			}
		}

		for (int i = page_lim1; i < pageid; i++) {
			if (f_name_js.trim().compareTo("") != 0) {
				st += separator + "<a href='javascript:" + f_name_js + "(\""
						+ urlEncode + "\", " + i + ")' class='txtBlue'>" + i
						+ "</a> ";
			} else {
				st += separator + "<a href='" + url + cc + "page=" + i
						+ "&isBack=1' class='txtBlue'>" + i + "</a> ";
			}
		}

		st += separator + "<span class='txtGrey11'>" + pageid + "</span>&nbsp;";

		for (int i = pageid + 1; i <= page_lim2; i++) {
			if (f_name_js.trim().compareTo("") != 0) {
				st += separator + "<a href='javascript:" + f_name_js + "(\""
						+ urlEncode + "\", " + i + ")' class='txtBlue'>" + i
						+ "</a> ";
			} else {
				st += separator + "<a href='" + url + cc + "page=" + i
						+ "&isBack=1' class='txtBlue'>" + (i) + "</a> ";
			}
		}
		st += separator;

		if (page_num > 1) {
			if (pageid + 1 <= page_num) {
				if (f_name_js.trim().compareTo("") != 0) {
					if (next_str.trim().compareTo("") != 0)
						st += " <a href='javascript:" + f_name_js + "(\""
								+ urlEncode + "\", " + (pageid + 1)
								+ ")' class='txtBlue'>" + next_str + "</a>";
					if (last_str.trim().compareTo("") != 0)
						st += separator + " &nbsp;<a href='javascript:"
								+ f_name_js + "(\"" + urlEncode + "\", "
								+ page_num + ")' class='txtBlue'>" + last_str
								+ "</a>";
				} else {
					if (next_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc + "page=" + (pageid + 1)
								+ "&isBack=1' class='txtBlue'>" + next_str
								+ "</a>";
					if (last_str.trim().compareTo("") != 0)
						st += "  <a href='" + url + cc + "page=" + page_num
								+ "&isBack=1' class='txtBlue'>" + last_str
								+ "</a>";
				}
			}
		} else {
			st = "";
		}
		return st;
	}

	/**
	 * Escape special chars html
	 *
	 * @param content
	 *            String
	 * @return String htmlspecialchars
	 */
	public static String escapeHTML(String content) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);

			switch (c) {
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;

			case '&':
				sb.append("&amp;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			 case '\'':
				sb.append("&apos;");
				break;
			default:
				sb.append(c);
			}
		}
		content = sb.toString();
		return content;
	}

	/**
	 * escapeInjection
	 *
	 * @param str
	 *            String
	 * @return String escapeInjection
	 */
	public static String escapeInjection(String str) {
//		String tem = str.replace("'", "''");
		String tem = str.replace("\\", "\\\\").replace("%", "\\%");
		return tem;
	}

	/**
	 * Kiá»ƒm tra user Ä‘Ã£ Ä‘Äƒng nháº­p chÆ°a
	 *
	 * @param session HttpSession
	 * @return true: Ä‘Ã£ Ä‘Äƒng nháº­p / false: chÆ°a Ä‘Äƒng nháº­p
	 */
	public static boolean checkLogin(HttpSession session) {
		boolean result = false;

		if (session.getAttribute("loginId") != null) {
			result = true;
		}

		return result;
	}

	/**
	 * Táº¡o chuá»—i paging
	 *
	 * @param totalRecords
	 *            tá»•ng sÃ´ record
	 * @param limit
	 *            sá»‘ record trÃªn 1 trang
	 * @param currentPage
	 *            trang hiá»‡n táº¡i
	 * @return List<Integer> chuoi lien ket den cac trang khac
	 */
	public static List<Integer> getListPaging(int totalRecords, int limit,
			int currentPage) {
		List<Integer> lsPaging = new ArrayList<Integer>();
		// Tá»•ng sá»‘ trang
		int totalPage = 0;
		int range = 3;

		if (limit != 0) {
			totalPage = getTotalPage(totalRecords, limit);
		}

		if (totalPage == 0) {
			currentPage = 0;
		}

		int currentSequence = getCurrentSequence(currentPage, range);
		int lastPage = getLastPage(currentSequence, range);
		int firstPage = getFirstPage(currentSequence, range);

		if(lastPage > totalPage) {
			lastPage = totalPage;
		}

		int pageAdd = firstPage;
		while(pageAdd <= lastPage) {
			lsPaging.add(pageAdd++);
		}

		return lsPaging;
	}

	/**
	 * Láº¥y tá»•ng sá»‘ trang
	 * @param totalRecords tá»•ng sá»‘ báº£n ghi
	 * @param limit sá»‘ báº£n ghi 1 trang
	 * @return tá»•ng sá»‘ trang
	 */
	public static int getTotalPage(int totalRecords, int limit) {
		return (int) Math.ceil((double) totalRecords / limit);
	}

	/**
	 * Láº¥y sequence hiá»‡n táº¡i
	 * @param currentPage trang hiá»‡n táº¡i
	 * @param range sá»‘ trang hiá»ƒn thá»‹
	 * @return sequence hiá»‡n táº¡i
	 */
	public static int getCurrentSequence(int currentPage, int range) {
		return (int) Math.ceil((double) currentPage / range);
	}

	/**
	 * Láº¥y trang lá»›n nháº¥t trong sequence hiá»‡n táº¡i
	 * @param currentSequence sequence hiá»‡n táº¡i
	 * @param range sá»‘ trang hiá»ƒn thá»‹
	 * @return trang lá»›n nháº¥t trong sequence hiá»‡n táº¡i
	 */
	public static int getLastPage(int currentSequence, int range) {
		return currentSequence * range;
	}

	/**
	 * Láº¥y trang nhá»� nháº¥t trong sequence hiá»‡n táº¡i
	 * @param currentSequence sequence hiá»‡n táº¡i
	 * @param range sá»‘ trang hiá»ƒn thá»‹
	 * @return trang nhá»� nháº¥t trong sequence hiá»‡n táº¡i
	 */
	public static int getFirstPage(int currentSequence, int range) {
		return getLastPage(currentSequence, range) - (range - 1);
	}

	/**
	 * Kiá»ƒm tra 2 chuá»—i trÃ¹ng nhau
	 *
	 * @param s1 String
	 * @param s2 String
	 * @return true: 2 chuá»—i trÃ¹ng nhau / false: 2 chuá»—i khÃ´ng trÃ¹ng nhau
	 */
	public static boolean checkEquals(String s1, String s2) {
		boolean rs = false;

		if(s1.toUpperCase().trim().equals(s2.toUpperCase().trim())) {
			rs = true;
		}

		return rs;
	}

	/**
	 * Láº¥y danh sÃ¡ch cÃ¡c nÄƒm
	 * @param start nÄƒm báº¯t Ä‘áº§u
	 * @param end nÄƒm káº¿t thÃºc
	 * @return danh sÃ¡ch nÄƒm
	 */
	public static List<Integer> getListYear(int start, int end) {
		List<Integer> lsYear = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			lsYear.add(i);
		}

		return lsYear;
	}

	/**
	 * Láº¥y danh sÃ¡ch cÃ¡c thÃ¡ng
	 * @return danh sÃ¡ch cÃ¡c thÃ¡ng
	 */
	public static List<Integer> getListMonth() {
		List<Integer> lsMonth = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			lsMonth.add(i);
		}

		return lsMonth;
	}

	/**
	 * Láº¥y danh sÃ¡ch cÃ¡c ngÃ y
	 * @return danh sÃ¡ch cÃ¡c ngÃ y
	 */
	public static List<Integer> getListDay() {
		List<Integer> lsDay = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			lsDay.add(i);
		}

		return lsDay;
	}

	/**
	 * HÃ m kiá»ƒm tra trá»‘ng
	 *
	 * @param input
	 *            chuá»—i nháº­p vÃ o
	 * @return true: null / false: not null
	 */
	public static boolean checkNull(String input) {
		boolean result = false;
		if (input.trim().length() == 0) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra Ä‘á»™ dÃ i chuá»—i
	 *
	 * @param input
	 *            chuá»—i nháº­p vÃ o
	 * @param min
	 *            Ä‘á»™ dÃ i tá»‘i thiá»ƒu
	 * @param max
	 *            Ä‘á»™ dÃ i tá»‘i Ä‘a
	 * @return true: náº±m ngoÃ i khoáº£ng cho phÃ©p / false: náº±m trong khoáº£ng cho phÃ©p
	 */
	public static boolean checkMinMaxLength(String input, int min, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length < min || length > max) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra Ä‘á»™ dÃ i chuá»—i
	 *
	 * @param input
	 *            chuá»—i nháº­p vÃ o
	 * @param max
	 *            Ä‘á»™ dÃ i tá»‘i Ä‘a cá»§a chuá»—i
	 * @return true: lá»›n hÆ¡n Ä‘á»™ dÃ i tá»‘i Ä‘a / false: nhá»� hÆ¡n Ä‘á»™ dÃ i tá»‘i Ä‘a
	 */
	public static boolean checkMaxLength(String input, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length > max) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra chuá»—i cÃ³ kÃ½ tá»± nÃ o ko pháº£i tiáº¿ng Nháº­t khÃ´ng
	 *
	 * @param input
	 *            chuá»—i nháº­p vÃ o
	 * @return true: khÃ´ng pháº£i chuá»—i katakana / false: lÃ  chuá»—i katakana
	 */
	public static boolean checkNotKanaString(String input) {
		boolean result = true;
		char[] tmp = input.toCharArray();
		for (char c : tmp) {
			if (Character.UnicodeBlock.of(c) == UnicodeBlock.KATAKANA) {
				result = false;
			} else {
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * HÃ m kiá»ƒm tra valid ngÃ y sinh
	 *
	 * @param input
	 *            Date ngÃ y sinh
	 * @return true: ngÃ y khÃ´ng tá»“n táº¡i / false: ngÃ y tá»“n táº¡i
	 */
	public static boolean checkNotValidDay(int year, int month, int date) {
		if (date < 1) {
			return true;
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (date > 31) {
				return true;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (date > 30) {
				return true;
			}
		case 2:
			if (year % 4 == 0 && date > 29) {
				return true;
			}
			if (year % 4 != 0 && date > 28) {
				return true;
			}
		}

		return false;
	}

	/**
	 * So sÃ¡nh ngÃ y chá»‰ Ä‘á»‹nh vá»›i ngÃ y hiá»‡n táº¡i
	 *
	 * @param input
	 *            ngÃ y chá»‰ Ä‘á»‹nh
	 * @return <0 náº¿u ngÃ y chá»‰ Ä‘á»‹nh nhá»� hÆ¡n ngÃ y hiá»‡n táº¡i, 0 náº¿u báº±ng ngÃ y hiá»‡n
	 *         táº¡i, >0 náº¿u lá»›n hÆ¡n ngÃ y hiá»‡n táº¡i
	 */
	public static int compareToDay(Date input) {
		Date now = new Date();

		return input.compareTo(now);
	}

	/**
	 * Kiá»ƒm tra valid cho ngÃ y sinh vÃ  start date
	 * @param input ngÃ y sinh / start date
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidBirth(int year, int month, int date) {
		boolean result = checkNotValidDay(year, month, date);

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date);
		Date input = c.getTime();

		if(!result) {
			if(compareToDay(input) > 0) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra valid cho end date
	 * @param input end date
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidEnd(int year, int month, int date) {
		boolean result = checkNotValidDay(year, month, date);

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date);
		Date input = c.getTime();

		if(!result) {
			if(compareToDay(input) < 0) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra format email
	 * @param input chuá»—i nháº­p vÃ o
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidEmail(String input) {
		boolean result = true;
		String regex = "[\\w]+(@)[\\w]+((.)[\\w]+)+";
		Pattern p = Pattern.compile(regex);

		if (p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra format phone number
	 * @param input chuá»—i nháº­p vÃ o
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidPhone(String input) {
		boolean result = true;
		String regex = "[\\d]+[-][\\d]+[-]([\\d]+)";
		Pattern p = Pattern.compile(regex);

		if(p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra 1 chuá»—i cÃ³ pháº£i chá»©a táº¥t cáº£ kÃ½ tá»± 1 byte hay khÃ´ng
	 * @param input chuá»—i nháº­p vÃ o
	 * @return true: khÃ´ng cÃ³ kÃ½ tá»± nÃ o >1byte / false: chá»©a kÃ½ tá»± >1byte
	 */
	public static boolean is1Byte(String input) {
		boolean result = true;
		char[] c = input.toCharArray();

		for (char tmp : c) {
			if (tmp > 255) {
				result = false;
			}
			break;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra 1 chuá»—i cÃ³ pháº£i chuá»—i sá»‘ half size khÃ´ng
	 * @param input chuá»—i nháº­p vÃ o
	 * @return true: sá»‘ halfsize / false: khÃ´ng pháº£i sá»‘ halfszie
	 */
	public static boolean isNumberHalfSize(String input) {
		boolean result = true;
		try {
			int tmp = Integer.parseInt(input);
			result = is1Byte(input);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			result = false;
		}

		return result;
	}

	/**
	 * Kiá»ƒm tra 1 chuá»—i cÃ³ náº±m trong format (a-z, A-Z, 0-9 vÃ  _)
	 * @param input chuá»—i nháº­p vÃ o
	 * @return true: chá»‰ chá»©a cÃ¡c ká»¹ tá»± (a-z, A-Z, 0-9 vÃ  _) / false: khÃ´ng Ä‘Ãºng format
	 */
	public static boolean checkFormatUser(String input) {
		boolean result = true;
		char[] c = input.toCharArray();
		int i = 1;

		for (char tmp : c) {
			int ascii = (int)tmp;
			if (ascii < 48 || (ascii > 57 && ascii < 65) ||
					(ascii > 90 && ascii < 95) || (ascii > 95 && ascii < 97) ||
					ascii > 122) {
				result = false;
				break;
			}
			if (ascii >= 48 && ascii <= 57 && i == 1) {
				result = false;
				break;
			}
			i++;
		}

		return result;
	}

	/**
	 * MÃ£ hÃ³a chuá»—i nháº­p vÃ o
	 * @param str chuá»—i nháº­p vÃ o
	 * @return Chuá»—i sau khi mÃ£ hÃ³a
	 */
	public static String endcodeString(String str) {
		String rs = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte messageDigest[] = md5.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < messageDigest.length; i++) {
	            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	        }
	        rs = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("an exception occur: " + e.getMessage());
			rs = "";
		}

		return rs;
	}

	/**
	 * TÃ­nh Ä‘iá»ƒm trung bÃ¬nh cá»§a mÃ´n há»�c
	 * @param diem Diem Ä‘á»‘i tÆ°á»£ng Ä‘iá»ƒm
	 * return Float Ä‘iá»ƒm TB
	 */
	public static float getDiemTBMonHoc(Diem diem) {
		float rs = 0.0f;

		MonHoc tmp = diem.getMonHoc();
		rs += diem.getDiemChuyenCan() * tmp.getHeSoChuyenCan();
		rs += diem.getDiemGiuaKy() * tmp.getHeSoGiuaKy();
		rs += diem.getDiemThi() * tmp.getHeSoHocKy();
		rs /= (tmp.getHeSoChuyenCan() + tmp.getHeSoGiuaKy() + tmp.getHeSoHocKy());

		return rs;
	}

	/**
	 * TÃ­nh Ä‘iá»ƒm trung bÃ¬nh há»�c ká»³
	 * @param lsDiem List<Diem> danh sÃ¡ch Ä‘iá»ƒm cÃ¡c mÃ´n trong há»�c ká»³
	 * @return Float Ä‘iá»ƒm TB
	 */
	public static float getDiemTBHK(List<Diem> lsDiem) {
		Float rs = 0.0f;

		for (Diem object : lsDiem) {
			Float diemMonHoc = 0.0f;
			diemMonHoc = Common.getDiemTBMonHoc(object);

			rs += diemMonHoc;
		}
		rs /= lsDiem.size();

		return rs;
	}
}
