<%-- 
    Document   : resultado-busqueda
    Created on : 9/05/2020, 04:11:51 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Hospital - Búsqueda de pacientes">
    <section class="card shadow-sm mx-sm-n1">
        <div class="card-body">
            <p class="font-weight-bold">Buscar pacientes por ciudad</p>
            <form method="GET">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Ej: Orizaba" name="q" value="${q}">
                    <div class="input-group-append">
                        <button class="btn btn-info" type="submit">Buscar</button>
                    </div>
                </div>
            </form>
        </div>
    </section>

    <c:if test="${buscado}">
        <c:choose>
            <c:when test="${error != null}">
                <section class="card shadow-sm mt-2 bg-danger text-white">
                    <div class="card-body">
                        <p class="h5 card-title">Ups! Parece que ocurrió un error</p>
                        <p class="card-text">${error.message}</p>
                    </div>
                </section>
            </c:when>
            <c:when test="${empty resultados}">
                <section class="card shadow-sm mt-2">
                    <div class="card-body">
                        <p class="h5 card-title text-info">Sin resultados</p>
                        <p class="card-text">No se encontraron pacientes de <strong>"${q}"</strong></p>
                    </div>
                </section>
            </c:when>
            <c:otherwise>
                <div class="form-group d-flex mt-2 mb-0 align-items-center">
                    <div class="col p-0 text-right">
                        <label class="m-0" for="exampleFormControlSelect2">
                            Resultados por página
                        </label>
                    </div>
                    <div class="col-3 col-md-2 col-lg-1 pr-0">
                        <select class="form-control" id="exampleFormControlSelect2">
                            <option>5</option>
                            <option>10</option>
                        </select>
                    </div>
                </div>

                <div class="d-flex flex-wrap justify-content-between">
                    <c:forEach items="${resultados}" var="paciente" varStatus="status">
                        <section class="card shadow-sm mt-2 col-sm-6 col-xl-4 p-0 mx-sm-n1">
                            <div class="row no-gutters">
                                <div class="col-4 d-flex align-items-center">
                                    <img src="${paciente.photo}" class="card-img rounded-0" alt="">
                                </div>
                                <div class="col-8">
                                    <div class="card-body px-2 py-1 h-100 d-flex flex-column">
                                        <p class="card-title m-0 h6 text-truncate">
                                            ${paciente.nombre} ${paciente.apPaterno} ${paciente.apMaterno}
                                        </p>
                                        <p class="card-text m-0 text-truncate">
                                            <small class="text-muted">
                                                ${paciente.direccion.direccion}
                                            </small>
                                        </p>
                                        <p class="card-text m-0 text-truncate">
                                            <small class="text-muted">
                                                ${paciente.direccion.ciudad}
                                            </small>
                                        </p>
                                        <p class="card-text m-0">
                                            <small class="text-muted">
                                                Tel: ${paciente.telefono}
                                            </small>
                                        </p>
                                        <div class="d-flex justify-content-between align-items-center">
                                            <p class="m-0 text-muted">
                                                <small>Expediente: ${paciente.idExpediente}</small>
                                            </p>
                                            <a href='<c:url value="/paciente/${paciente.idExpediente}" />' class="btn btn-link">
                                                Ver detalle
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </c:forEach>
                </div>

                <nav class="d-flex justify-content-center mt-2">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="#">Anterior</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">Siguiente</a>
                        </li>
                    </ul>
                </nav>
            </c:otherwise>
        </c:choose>
    </c:if>
</t:layout>