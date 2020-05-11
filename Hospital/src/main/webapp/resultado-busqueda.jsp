<%-- 
    Document   : resultado-busqueda
    Created on : 9/05/2020, 04:11:51 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Hospital - Búsqueda de pacientes">
    <section class="card shadow-sm">
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
                <c:forEach items="${resultados}" var="paciente">
                    <section class="card shadow-sm mt-2">
                        <div class="row no-gutters">
                            <div class="col-4">
                                <img src="${paciente.photo}" class="card-img" alt="">
                            </div>
                            <div class="col-8">
                                <div class="card-body px-2 pt-2 pb-1 h-100 d-flex flex-column">
                                    <p class="card-title m-0 h6">
                                        ${paciente.nombre} ${paciente.apPaterno} ${paciente.apMaterno}
                                    </p>
                                    <p class="card-text">
                                        <small class="text-muted">
                                            ${paciente.direccion.direccion}, ${paciente.direccion.ciudad}
                                        </small>
                                    </p>
                                    <div class="d-flex justify-content-between push-bottom align-items-center">
                                        <p class="m-0 text-muted">
                                            <small>
                                                Expediente: ${paciente.idExpediente}
                                            </small>
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
            </c:otherwise>
        </c:choose>
    </c:if>
</t:layout>