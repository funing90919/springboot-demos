package top.osfun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import top.osfun.uitl.DateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemosApplicationTests {

	@Autowired
	private JavaMailSenderImpl mailSerder;

	@Value("${spring.mail.username}")
	private String mailFrom;

	@Test
	public void simpleMail() {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(mailFrom);
		mail.setTo(new String[] {"90919@163.com", "78538@qq.com"});
		mail.setSubject("春节放假通知");
		mail.setText("哈哈，骗你的！--本邮件发自SpringBoot单元测试" + this.getClass());
		mailSerder.send(mail);
	}

	@Test
    public void comlexMail() throws MessagingException {
	    // 1.创建复杂消息
        MimeMessage mimeMessage = mailSerder.createMimeMessage();
        // 2.组装邮件
        MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, true);
        mail.setFrom(mailFrom);
        mail.setTo(new String[] {"90919@163.com", "78538@qq.com"});
        mail.setSubject("春节放假通知");
        mail.setText("<b style='color: red;'>哈哈，骗你的！</b>--本邮件发自SpringBoot单元测试" + this.getClass(), true);
        // 上传附件
        mail.addAttachment("aa.png", new File("C:\\Users\\Jacky\\Pictures\\PIC\\21.png"));
        mailSerder.send(mimeMessage);
    }

    @Test
	public void dateUtilsTest() {
		Date parse1 = DateUtils.parse("2018", DateUtils.DateFormatter.YYYY);
		Date parse2 = DateUtils.parse("2018-12", DateUtils.DateFormatter.YYYY_MM);
		Date parse3 = DateUtils.parse("2018-12-12", DateUtils.DateFormatter.YYYY_MM_DD);
		Date parse4 = DateUtils.parse("2018-12-12 00:11:22", DateUtils.DateFormatter.YYYY_MM_DD_HH_MM_SS);
		System.err.println(parse1);
		System.err.println(parse2);
		System.err.println(parse3);
		System.err.println(parse4);
		String format1 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYY);
		String format2 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYY_MM);
		String format3 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYMM_STR);
		String format4 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYYMM_STR);
		String format5 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYY_MM_DD);
		String format6 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYMMDD_STR);
		String format7 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYYMMDD_STR);
		String format8 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYY_MM_DD_HH_MM_SS);
		String format9 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYMMDDHHMMSS_STR);
		String format10 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYYMMDDHHMMSS_STR);
		String format11 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYMMDDHHMMSSSSS_STR);
		String format12 = DateUtils.format(new Date(), DateUtils.DateFormatter.YYYYMMDDHHMMSSSSS_STR);
		System.err.println(format1);
		System.err.println(format2);
		System.err.println(format3);
		System.err.println(format4);
		System.err.println(format5);
		System.err.println(format6);
		System.err.println(format7);
		System.err.println(format8);
		System.err.println(format9);
		System.err.println(format10);
		System.err.println(format11);
		System.err.println(format12);
	}
}

