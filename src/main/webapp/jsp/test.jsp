<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/3/26
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery/jquery-2.0.min.js"></script>
    <script type="text/javascript">
        $.ajax({
            url: "/index",
            type: "POST",
            data: {},
            dataType: "json",
            success: function (data) {
                console.log(data);
            }
        });
    </script>
</head>
<body>

</body>
</html>
