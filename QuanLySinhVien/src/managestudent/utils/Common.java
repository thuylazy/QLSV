
package managestudent.utils;

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

public class Common {

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


	public static boolean checkLogin(HttpSession session) {
		boolean result = false;

		if (session.getAttribute("loginId") != null) {
			result = true;
		}

		return result;
	}


	public static List<Integer> getListPaging(int totalRecords, int limit,
			int currentPage) {
		List<Integer> lsPaging = new ArrayList<Integer>();
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

	public static int getTotalPage(int totalRecords, int limit) {
		return (int) Math.ceil((double) totalRecords / limit);
	}


	public static int getCurrentSequence(int currentPage, int range) {
		return (int) Math.ceil((double) currentPage / range);
	}


	public static int getLastPage(int currentSequence, int range) {
		return currentSequence * range;
	}


	public static int getFirstPage(int currentSequence, int range) {
		return getLastPage(currentSequence, range) - (range - 1);
	}


	public static boolean checkEquals(String s1, String s2) {
		boolean rs = false;

		if(s1.toUpperCase().trim().equals(s2.toUpperCase().trim())) {
			rs = true;
		}

		return rs;
	}

	public static List<Integer> getListYear(int start, int end) {
		List<Integer> lsYear = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			lsYear.add(i);
		}

		return lsYear;
	}


	public static List<Integer> getListMonth() {
		List<Integer> lsMonth = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			lsMonth.add(i);
		}

		return lsMonth;
	}

	public static List<Integer> getListDay() {
		List<Integer> lsDay = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			lsDay.add(i);
		}

		return lsDay;
	}


	public static boolean checkNull(String input) {
		boolean result = false;
		if (input.trim().length() == 0) {
			result = true;
		}

		return result;
	}


	public static boolean checkMinMaxLength(String input, int min, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length < min || length > max) {
			result = true;
		}

		return result;
	}


	public static boolean checkMaxLength(String input, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length > max) {
			result = true;
		}

		return result;
	}

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

	public static int compareToDay(Date input) {
		Date now = new Date();

		return input.compareTo(now);
	}


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

	public static boolean checkNotValidEmail(String input) {
		boolean result = true;
		String regex = "[\\w]+(@)[\\w]+((.)[\\w]+)+";
		Pattern p = Pattern.compile(regex);

		if (p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}


	public static boolean checkNotValidPhone(String input) {
		boolean result = true;
		String regex = "[\\d]+[-][\\d]+[-]([\\d]+)";
		Pattern p = Pattern.compile(regex);

		if(p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}

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


	public static boolean isNumberHalfSize(String input) {
		boolean result = true;
		try {
			@SuppressWarnings("unused")
			int tmp = Integer.parseInt(input);
			result = is1Byte(input);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			result = false;
		}

		return result;
	}


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

	public static float getDiemTBMonHoc(Diem diem) {
		float rs = 0.0f;

		MonHoc tmp = diem.getMonHoc();
		rs += diem.getDiemChuyenCan() * tmp.getHeSoChuyenCan();
		rs += diem.getDiemGiuaKy() * tmp.getHeSoGiuaKy();
		rs += diem.getDiemThi() * tmp.getHeSoHocKy();
		rs /= (tmp.getHeSoChuyenCan() + tmp.getHeSoGiuaKy() + tmp.getHeSoHocKy());

		return rs;
	}

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
