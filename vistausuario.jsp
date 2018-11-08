<%@ page language='java' contentType='text/html;charset=utf-8' %>
<%@ page import='java.util.List' %>
<%@ page import='debate.Debate' %>
<!DOCTYPE html>
<html >
   <head >
     <title> Catálogo </title>
			</head >
			<body >
                <% List<Book> catalog = (List<Book>) request.getAttribute("catalog"); %>
				<form action="addToCart">
				<% for (Book book: catalog) { %>
				<div>
				<label>
					<input type="checkbox" name="selectedBooks" value="<%= book.getIsbn() %>">
					<%= book.getTitle() %>
					
				</label>
				</div>
				<% } %>
				</form>
			</body >
		</html >
