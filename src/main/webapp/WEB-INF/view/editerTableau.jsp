<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <link
    rel="stylesheet"
    type="text/css"
    href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
  />
  <c:url value="/css/main.css" var="jstlCss" />
  <link href="${jstlCss}" rel="stylesheet" />
  <script
    type="text/javascript"
    src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"
  ></script>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256" />
    <title>Modifier un Tableau</title>
  </head>
  <body>
    <div class="container mt-5">
      <div class="card-body">
        <form action="updateProduit" method="post">
          <div class="form-group">
            <label class="control-label">ID Tableau :</label>
            <input
              type="text"
              name="idTableau"
              value="${tableau.idTableau}"
              readonly
              class="form-control"
            />
          </div>
          <div class="form-group">
            <label class="control-label">Nom Tableau :</label>
            <input
              type="text"
              name="nomTableau"
              value="${tableau.nomTableau}"
              class="form-control"
            />
          </div>
          <div class="form-group">
            <label class="control-label">Prix Tableau :</label>
            <input
              type="text"
              name="prixTableau"
              value="${tableau.prixTableau}"
              class="form-control"
            />
          </div>
          <div class="form-group">
            <label class="control-label">Painteur</label>
            <input
              type="text"
              name="painterTableau"
              value="${tableau.painterTableau}"
              class="form-control"
            />
          </div>
          <div class="form-group">
            <label class="control-label"> Date creation :</label>
            <fmt:formatDate
              pattern="yyyy-MM-dd"
              value="${tableau.dateCreation}"
              var="formatDate"
            />

            <input
              type="date"
              name="date"
              value="${formatDate}"
              class="form- control"
            />
          </div>
          <div>
            <button type="submit" class="btn btn-primary">Modifier</button>
          </div>
        </form>
      </div>
      <br />
      <br />
      <a href="ListeTableaux">Liste Tableaux</a>
    </div>
  </body>
</html>
