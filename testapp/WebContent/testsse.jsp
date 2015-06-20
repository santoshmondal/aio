<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

UP :: <div id="up"></div>

<br />
DOWN :: <div id="down"></div>

</body>


<script type="text/javascript">
var eventSource = new EventSource("HelloSSE");

eventSource.addEventListener('up_vote', function(event) {
        document.getElementById('up').innerHTML = event.data;
        console.log(event.data);
}, false);
 
 
eventSource.addEventListener('down_vote', function(event) {
        document.getElementById('down').innerHTML = event.data;
        console.log(event.data);
        
}, false);	
</script>
</html>