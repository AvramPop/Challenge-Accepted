[#ftl]

[#if error??]
<div style="color:red">${error}</div>
[/#if]

<form method="POST" action="api/todo/create">
Title: <input name="title" value="${todo.title!''}"/>
<br>
Description: <input name="description" value="${todo.description!''}"/>
<br>
<input type="submit" value="save">
</form>