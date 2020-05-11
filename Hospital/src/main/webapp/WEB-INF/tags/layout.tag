<%-- 
    Document   : layout
    Created on : 2/05/2020, 05:25:07 PM
    Author     : hsanchez <hsanchez.dev@gmail.com>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag description="Common layout" pageEncoding="UTF-8"%>

<%@attribute name="title" required="true"
             description="The current page title"%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Hospital | ${title}</title>
        <link rel="stylesheet" href='<c:url value="/assets/css/index.css" />' />
    </head>
    <body>
        <nav class="navbar navbar-dark bg-info">
            <span class="navbar-brand mb-0 h1"> ${title} </span>
        </nav>

        <main class="container py-3">
            <jsp:doBody />
        </main>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const back = document.getElementById("back");
            const host = location.host + "/Hospital";
            
            if(document.referrer.includes(host)) {
                back.href = document.referrer;
            } else {
                const url = back.dataset.fallbackUrl;
                back.href = host + url;
            }
        });
    </script>
</html>