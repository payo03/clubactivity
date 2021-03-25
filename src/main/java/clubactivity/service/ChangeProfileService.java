package clubactivity.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.MemberDAO;
import clubactivity.exception.ImageUpdateException;
import clubactivity.exception.WrongIdPasswordException;
import clubactivity.vo.AuthInfo;
import clubactivity.vo.ChangeNumberCommand;
import clubactivity.vo.ChangePasswordCommand;
import clubactivity.vo.ChangeWebsiteCommand;
import clubactivity.vo.Image;
import clubactivity.vo.Member;

@Component
public class ChangeProfileService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional(rollbackFor = SQLException.class)
	public void changePassword(ChangePasswordCommand changePasswordCommand) throws Exception {
		Member member = memberDAO.selectMemberByMemberNumber(changePasswordCommand.getMemberNumber());
		if (!bCryptPasswordEncoder.matches(changePasswordCommand.getCurrentPassword(), member.getMemberPassword())) {
			throw new WrongIdPasswordException("password.notMatch");
		}

		member.changePassword(bCryptPasswordEncoder.encode(changePasswordCommand.getNewPassword()));
		memberDAO.updatePassword(member);
	}

	@Transactional(rollbackFor = SQLException.class)
	public void changeProfile(Object object, int memberNumber) {
		Member member = memberDAO.selectMemberByMemberNumber(memberNumber);
		member.changeProfile(object);

		if (object instanceof ChangeNumberCommand) {
			memberDAO.updateNumber(member);
		} else if (object instanceof ChangeWebsiteCommand) {
			memberDAO.updateWebsite(member);
		}

	}

	@Transactional(rollbackFor = SQLException.class)
	public void changeStatus(HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		if (authInfo.getMemberonline().isMemberStatus()) {
			memberDAO.updateOffline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(false);
		} else {
			memberDAO.updateOnline(authInfo.getMemberNumber());
			authInfo.getMemberonline().setMemberStatus(true);
		}
	}

	@Transactional(rollbackFor = SQLException.class)
	public void updateImage(Image image, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("login");

		int result = memberDAO.updateImage(image);
		if (result != 1) {
			throw new ImageUpdateException("Image Update Error");
		}
		authInfo.getImage().setImagePath(image.getImagePath());
	}

}
