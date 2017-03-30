[#ftl]

[#if error??]
<div style="color:red">${error}</div>
[/#if]

<form method="POST" action="api/admin/create">
Email: <input type="text" name="email" value="${admin.email!''}"/>
<br>
Password: <input type="password" name="password" value="${admin.password!''}"/>
<br>
First Name: <input type="text" name="firstName" value="${admin.firstName!''}"/>
<br>
Password: <input type="text" name="lastName" value="${admin.lastName!''}"/>
<br>
<input type="submit" value="save">
</form>