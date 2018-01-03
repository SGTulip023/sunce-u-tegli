<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" id="top">
    <h1>Sunce u Tegli</h1>
    <h3>Najsladji med!</h3>
    <p id="ph">Hodor! Hodor hodor, hodor hodor; hodor hodor?! Hodor, hodor hodor hodor; hodor hodor hodor hodor... Hodor hodor hodor, hodor, hodor hodor. Hodor! Hodor hodor, hodor... Hodor hodor hodor - hodor. Hodor. Hodor! Hodor hodor, hodor; hodor HODOR hodor, hodor hodor, hodor, hodor hodor. Hodor hodor - hodor hodor; hodor hodor? Hodor hodor - hodor; hodor hodor, hodor. Hodor hodor, hodor. Hodor hodor. Hodor, hodor. Hodor. Hodor, hodor - hodor? Hodor, hodor hodor hodor; hodor hodor hodor? Hodor, hodor - hodor hodor hodor, hodor, hodor hodor. </p>
</div>

<nav class="navbar" data-spy="affix" data-offset-top="197">
    <div class="wrapper">
        <ul class="nav navbar-nav">
            <li class="active"><a href="index">sunceutegli.com</a></li>
            <li><a href="index">Pocetna</a></li>
            <li><a href="avioLetovi">Lista avio letova</a></li>
        </ul>

        <!-- ukoliko korisnik nije ulogovan ne moze da ima dostupno logout, 
        u slucaju da je admin dodatno mu se pojavljuje administracija --> 
        <ul class="nav navbar-nav navbar-right">
            
                <li><a id="ulogovan" href="#">Dobrodosao/la ${sessionScope.korisnik.korIme}</a></li>
            
                    <li><a href="registracija">Registracija</a></li>
                    <li><a href="login">Login</a></li>
                
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracija
                            <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="dodajLet">Dodavanje novog leta</a></li>
                                <li><a href="izmenaLeta">Izmena postojeceg leta</a></li>
                                <li><a href="pregledRezervacija">Pregled rezervacija</a></li>
                                <li><a href="izmenaKorisnika">Pregled korisnika</a></li>
                            </ul>
                        </li>
                    
                    <li><a href="logout">Logout</a></li>
                    

        </ul>
    </div>
</nav>