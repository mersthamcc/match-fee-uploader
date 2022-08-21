<#macro mainLayout>
    <html>
    <head>
        <title>Match Fee Loader</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    </head>
    <body>

    <main>
        <h1 class="visually-hidden">Match Fee Loader</h1>
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <svg class="bi me-2" width="40" height="32">
                        <use xlink:href="#bootstrap"></use></svg>
                    <span class="fs-4">Match Fee Loader</span>
                </a>

                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a href="/" class="nav-link <#if springMacroRequestContext.requestUri == "/">active</#if>"
                           <#if springMacroRequestContext.requestUri == "/">aria-current="page"</#if>>
                            Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/upload" class="nav-link <#if springMacroRequestContext.requestUri == "/upload">active</#if>"
                           <#if springMacroRequestContext.requestUri == "/upload">aria-current="page"</#if>>
                            Upload
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="/match" class="nav-link <#if springMacroRequestContext.requestUri == "/match">active</#if>"
                           <#if springMacroRequestContext.requestUri == "/match">aria-current="page"</#if>>
                            Match
                        </a>
                    </li>
                </ul>
            </header>
        </div>
        <div class="b-example-divider"></div>

        <div class="container">
            <#nested />
        </div>
    </main>

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>