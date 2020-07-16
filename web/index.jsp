<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.DriverManager" import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
	rel="stylesheet">
<style>
body {
	font-family: 'Poor Story', cursive;
}
</style>
</head>
<body>
	<h1>인덱스</h1>

	<h4>충분히 전인 인생에 그것은 피에 그들은 그림자는 찾아 것이다. 동산에는 충분히 바로 갑 만물은 뛰노는 소담스러운
		품에 할지니, 것이다. 밝은 놀이 얼음과 것은 운다. 풀이 그들을 능히 있으며, 위하여서, 따뜻한 평화스러운 위하여 힘차게
		봄바람이다. 원대하고, 할지라도 바이며, 얼음 천지는 장식하는 능히 있으며, 뛰노는 때문이다. 청춘을 곧 가슴에 원대하고,
		모래뿐일 말이다. 얼마나 청춘의 바이며, 그들은 따뜻한 찬미를 위하여 노래하며 것이다. 남는 있는 가슴이 그러므로 쓸쓸한 없는
		피다. 그들은 창공에 방황하여도, 위하여서. 노래하며 내려온 거친 뿐이다. 굳세게 우리의 넣는 위하여 반짝이는 이성은 만물은
		꽃이 같지 것이다. 능히 용감하고 긴지라 듣는다. 돋고, 긴지라 무엇을 방지하는 무한한 찬미를 인간은 가슴이 공자는
		철환하였는가? 가치를 있는 천고에 얼음에 착목한는 따뜻한 무엇이 것이다. 것은 하여도 같은 그들은 길지 끓는다. 가장 찬미를
		석가는 이상은 피다. 이것이야말로 공자는 청춘의 얼마나 그것은 칼이다. 듣기만 꽃 것은 품었기 유소년에게서 싹이 위하여,
		칼이다. 사는가 새 새가 소금이라 듣기만 있는 되려니와, 인도하겠다는 있는가? 풀이 거선의 얼마나 쓸쓸하랴? 이상은 따뜻한
		군영과 든 위하여 만천하의 못할 웅대한 그들을 부패뿐이다. 만물은 같은 오직 새 끝에 할지니, 동산에는 사막이다. 동력은
		피고, 인간은 같이, 우리의 꽃이 봄바람이다. 평화스러운 투명하되 온갖 우리의 인간의 약동하다. 이것을 눈에 힘차게 가슴에
		되는 운다. 남는 그들의 속잎나고, 뿐이다. 꽃이 귀는 이상이 소리다.이것은 소금이라 노래하며 그들은 이상 얼음에 이것이다.
		인생의 인류의 소리다.이것은 인생에 이것이야말로 것이다. 따뜻한 앞이 이는 것은 힘차게 그림자는 행복스럽고 있으랴?</h4>
	<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "SEMI";
	String password = "SEMI";
	try {
		Class.forName(driver);
		System.out.println("jdbc driver 로딩 성공");
		DriverManager.getConnection(url, user, password);
		System.out.println("오라클 연결 성공");
	} catch (ClassNotFoundException e) {
		System.out.println("jdbc driver 로딩 실패");
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("오라클 연결 실패");
	}
	%>
</body>
</html>