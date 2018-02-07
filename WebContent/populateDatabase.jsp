<!doctype html">
<html>
<head>
<title>Populate Database</title>
<meta name="description" content="JSP simple form to populate the database">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Populate Database</h1>
		</div>
			<%@ include file="includes/navigation.jsp" %>	
			<div class="container">
				<form action="PopulateDatabase" method="post">
					<p>Click on the Populate button to populate the movie database.</p>
					<p>Warning: Submitting this form will reset the database and it will only contain those movies in the original spreadsheet!</p>
					<input type="submit" value="Populate!">
				</form>
			</div>
			
			<%@ include file="includes/footer.jsp" %>
		</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>