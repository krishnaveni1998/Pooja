<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}



.divred{
  border-radius: 5px;
  background-color: red;
  padding: 20px;
}
</style>
<body>


<div>
<h3>
      <c:if test = "${status == 'Success' }">
		<div>
		${username}, ur Login is ${status}
		</div>
      </c:if>

      <c:if test = "${status != 'Success' }">
		<div class="divred">
		${username}, ur Login is ${status}
		</div>
      </c:if>
<a href="/logout"> logout</a>
	<div>
		<form action="/destroy" method="post">
			<input type="submit" value="Destroy Session" />
		</form>
	</div>


</h3>

</div>

</body>
</html>
