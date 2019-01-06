package top.osfun.uitl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Date工具类
 */
public class DateUtils {

	private DateUtils() { }

	private static final ZoneId ZONE_ID = ZoneId.systemDefault();

	/**
	 * LocalDateTime转化为Date
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
	}

	/**
	 * LocalDateTime转化为Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZONE_ID).toInstant());
	}

	/**
	 * Date转化为LocalDateTime
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
	}

	/**
	 * LocalDate转化为LocalDateTime
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(LocalDate localDate) {
		return LocalDateTime.of(localDate, LocalTime.MIN);
	}

	/**
	 * Date转化为LocalDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate toLocalDate(Date date) {
		return date.toInstant().atZone(ZONE_ID).toLocalDate();
	}

	/**
	 * Date转化为字符串
	 * 
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String format(Date date, DateFormatter formatter) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
		return formatter.getDateTimeFormatter().format(localDateTime);
	}

	/**
	 * 字符串转化为Date
	 * 
	 * @param text
	 * @param formatter
	 * @return
	 */
	public static Date parse(String text, DateFormatter formatter) {
		return formatter.parse(text);
	}

	public static enum DateFormatter {

		/**
		 * 格式yyyy，日期与字符串双向转
		 */
		YYYY(DateTimeFormatter.ofPattern("yyyy", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				Year year = Year.parse(text, dateTimeFormatter);
				return Date.from(year.atDay(1).atStartOfDay(ZONE_ID).toInstant());
			}
		},

		/**
		 * 格式yyyy-MM，日期与字符串双向转
		 */
		YYYY_MM(DateTimeFormatter.ofPattern("yyyy-MM", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				YearMonth yearMonth = YearMonth.parse(text, dateTimeFormatter);
				return Date.from(yearMonth.atDay(1).atStartOfDay(ZONE_ID).toInstant());
			}
		},

		/**
		 * 
		 * 格式yyyy-MM-dd，日期与字符串双向转
		 */
		YYYY_MM_DD(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDate localDate = LocalDate.parse(text, dateTimeFormatter);
				return Date.from(localDate.atStartOfDay(ZONE_ID).toInstant());
			}
		},

		/**
		 * 格式yyyy-MM-dd HH:mm:ss，日期与字符串双向转
		 */
		YYYY_MM_DD_HH_MM_SS(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyMM，日期转字符串
		 */
		YYMM_STR(DateTimeFormatter.ofPattern("yyMM", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyyyMM，日期转字符串
		 */
		YYYYMM_STR(DateTimeFormatter.ofPattern("yyyyMM", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyMMdd，日期转字符串
		 */
		YYMMDD_STR(DateTimeFormatter.ofPattern("yyMMdd", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyyyMMdd，日期转字符串
		 */
		YYYYMMDD_STR(DateTimeFormatter.ofPattern("yyyyMMdd", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyMMddHHmmss，日期转字符串
		 */
		YYMMDDHHMMSS_STR(DateTimeFormatter.ofPattern("yyMMddHHmmss", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyyyMMddHHmmss，日期转字符串
		 */
		YYYYMMDDHHMMSS_STR(DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyMMddHHmmssSSS，日期转字符串
		 */
		YYMMDDHHMMSSSSS_STR(DateTimeFormatter.ofPattern("yyMMddHHmmssSSS", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		},
		
		/**
		 * 格式yyyyMMddHHmmssSSS，日期转字符串
		 */
		YYYYMMDDHHMMSSSSS_STR(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS", Locale.CHINA)) {
			@Override
			public Date parse(String text) {
				LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
				return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
			}
		};

		protected DateTimeFormatter dateTimeFormatter;

		private DateFormatter(DateTimeFormatter dateTimeFormatter) {
			this.dateTimeFormatter = dateTimeFormatter;
		}

		public DateTimeFormatter getDateTimeFormatter() {
			return dateTimeFormatter;
		}

		public abstract Date parse(String text);
	}

}