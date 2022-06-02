<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256" />
    <title>Liste Styles</title>
  </head>
  <body>
    <h1>Liste des Styles</h1>
    <table>
      <tr>
        <th>ID</th>
        <th>Nom Style</th>
        <th>Description</th>
        <th>Suppression</th>
        <th>Edition</th>
      </tr>
      <c:forEach items="${styles}" var="p">
        <tr>
          <td>${p.idS }</td>
          <td>${p.nomS }</td>
          <td>${p.descriptionS }</td>
          <td>
            <a
              onclick="return confirm('Etes-vous sur ?')"
              href="supprimerStyle?id=${p.idS }"
              >Supprimer</a
            >
          </td>
          <td><a href="modifierStyle?id=${p.idS }">Edit</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
