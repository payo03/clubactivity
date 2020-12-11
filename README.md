# clubactivity
 
# Table 생성(MySQL)

-- club.`member` definition

CREATE TABLE `member` (
  `MEMBER_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 아이디',
  `MEMBER_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 비밀번호',
  `MEMBER_NAME` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '회원이름',
  `MEMBER_PHONE_NUMBER` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '회원전화번호',
  `MEMBER_REGISTRATION_DATE` date DEFAULT NULL COMMENT '회원가입일자',
  `MEMBER_LEVEL_CODE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '1' COMMENT '회원등급',
  `MEMBER_NUMBER` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`MEMBER_NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- club.memberlevel definition

CREATE TABLE `memberlevel` (
  `MEMBER_LEVEL_CODE` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '회원등급',
  `MEMBER_LEVEL_DESCRIPTION` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '회원등급설명',
  PRIMARY KEY (`MEMBER_LEVEL_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# DB Property 파일 설정

src/main/resources
 - mybatis/config : S1, S2, S3, serverdb
