<%-- 
    Document   : index
    Created on : 9/05/2020, 04:11:51 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Hospital - Búsqueda de pacientes">
    <section class="card shadow-sm">
        <div class="card-body">
            <p class="font-weight-bold">Buscar pacientes por ciudad</p>
            <form action="GET">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Ej: Orizaba">
                    <div class="input-group-append">
                        <button class="btn btn-info" type="submit">Buscar</button>
                    </div>
                </div>
            </form>
        </div>
    </section>

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
            <section class="card shadow-sm mt-2">
                <div class="card-body p-0 table-responsive">
                    <table class="table">
                        <thead class="bg-info text-white">
                            <tr>
                                <th scope="col">Expediente</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellidos</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Ciudad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                                <td>@mdo</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </c:otherwise>
    </c:choose>
</t:layout>