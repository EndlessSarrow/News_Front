<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>新闻网</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
		a:hover{
			color: #f05f03;
		}
	</style>
</head>
<body>
<#list newsList as news>
<a href=show?htmlName=${news.htmlpath}>${news.title}</a><br />
</#list>
</body>
</html>


