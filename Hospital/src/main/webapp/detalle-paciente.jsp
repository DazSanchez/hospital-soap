<%-- 
    Document   : detalle-paciente
    Created on : 10/05/2020, 10:13:46 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<t:layout title="Hospital - Detalle de expediente">
    <section class="row">
        <div class="col">
            <a id="back" href="#" data-fallback-url="/">Volver a la búsqueda</a>
        </div>
    </section>

    <c:choose>
        <c:when test="${error != null}">
            <section class="card shadow-sm mt-2 bg-danger text-white col-12 p-0">
                <div class="card-body">
                    <p class="h5 card-title">Ups! Parece que ocurrió un error</p>
                    <p class="card-text">${error.message}</p>
                </div>
            </section>
        </c:when>
        <c:otherwise>
            <div class="d-flex flex-wrap justify-content-between">
                <section class="card shadow-sm mt-2 col-12 p-0 col-lg-6 rounded-0">
                    <div class="row no-gutters">
                        <div class="col-4 d-flex align-items-center">
                            <img src="${paciente.photo}" class="card-img rounded-0" alt="Imagen de perfil">
                        </div>
                        <div class="col-8">
                            <div class="card-body px-2 py-1 h-100 d-flex flex-column">
                                <p class="card-title m-0 h5">
                                    Información personal
                                </p>

                                <p class="card-text text-muted m-0">
                                    <small>Nombre completo</small>
                                </p>
                                <p class="card-text m-0">
                                    ${paciente.nombre} ${paciente.apPaterno} ${paciente.apMaterno}
                                </p>

                                <p class="card-text text-muted m-0">
                                    <small>Número de expediente</small>
                                </p>
                                <p class="card-text">
                                    ${paciente.idExpediente}
                                </p>
                            </div>
                        </div>
                    </div>
                </section>

                <section class="card shadow-sm mt-2 col-12 p-0 col-lg-6 rounded-0">
                    <div class="card-body px-3 py-2">
                        <p class="card-title mb-2 h5">
                            Información médica
                        </p>

                        <div class="row">
                            <div class="col">
                                <p class="card-text text-muted m-0">
                                    <small>Médico</small>
                                </p>
                                <p class="card-text m-0">
                                    ${medico.nombre} ${medico.apPaterno} ${medico.apMaterno}
                                </p>
                            </div>
                            <div class="col">
                                <p class="card-text text-muted m-0">
                                    <small>Área de especialidad</small>
                                </p>
                                <p class="card-text m-0">
                                    ${medico.especialidad.descripcion}
                                </p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <p class="card-text text-muted m-0">
                                    <small>Consultorio</small>
                                </p>
                                <p class="card-text m-0">
                                    ${consultorio.numero}
                                </p>
                            </div>
                            <div class="col">
                                <p class="card-text text-muted m-0">
                                    <small>Piso</small>
                                </p>
                                <p class="card-text m-0">
                                    ${consultorio.piso}
                                </p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

            <section class="card shadow-sm mt-2 col-12 p-0">
                <div class="card-body">
                    <p class="card-title mb-2 h5">
                        Consultas
                    </p>

                    <ul class="list-group list-group-flush">
                        <c:forEach items="${visitas}" var="visita">
                            <li class="list-group-item px-0">
                                <p class="text-muted m-0">
                                    <small>${visita.fechaFormateada} - Observaciones: </small>
                                </p>
                                ${visita.observaciones}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </section>
        </c:otherwise>
    </c:choose>

</t:layout>