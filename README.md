Este es un trabajo practico individual pedido por la materia programacion basica 2 de la universidad nacional de la matanza.
Todos los nuevos funcionamientos que fue recibiendo la inmobiliria fueron dados por los profes de la materia a lo largo de la misma. Cada tema nuevo visto equivalia a nuevos tests o cambios en la logica de los metodos, mejoras, etc

Las consignas del mismo son las que estan a continuacion: 
* Aclaro que estas son las ultimas consignas, hubo muchas versiones anteriores. se pueden ver en los primeros commits que por ejemplo el programa poseia un main para hacer las pruebas el cual fue reemplazado por JUnit
* Los Test y Excepciones que no figuran en las consignas, fueron agregador por mi para no dejar problemas sin resolver y demostrar lo aprendido a lo largo de la cursada




  Nos contratan para desarrollar un software que permita gestionar una inmobiliaria.
Las inmobiliarias se encargan de la comercialización de Propiedades (Casas, Departamentos, PH, Terrenos, Campos).
El objetivo principal de una inmobiliaria es realizar Operaciones (Ventas, Alquileres o Permutas).
La Venta es una operación donde una propiedad es vendida, es decir pasa de un Propietario A a su nuevo Propietario B.
El Alquiler es una operación donde una propiedad es alquilada, es decir, durante un período de tiempo, esa casa, departamento , PH, terreno o campo, además de Tener un Propietario, también tiene un Inquilino.
La Permuta es una Operación donde una propiedad A cambia su Propietario X a su nuevo Propietario Y, y al mismo tiempo la propiedad cambia su Propietario Y a X. Es un intercambio de propiedades entre los dueños.

1.	Se solicita desarrollar un software en Java, con un menú de opciones que permita:
a.	Agregar nuevas propiedades (Las propiedad se pueden repetir, porque distintos vendedores pueden cargar una misma propiedad con diferentes valores de venta por ejemplo)
b.	 Modificar propiedad existentes (La búsqueda de propiedad se realiza por código)
c.	Agregar clientes (Son aquellos que se encuentran en búsqueda de una propiedad. No se puede agregar dos clientes con un mismo DNI)
d.	Obtener listado de propiedades ordenado por precio.
e.	Obtener el listado de propiedades ordenado por ubicación.
f.	Buscar propiedades por diferentes parámetros:
i.	Rango de precios
ii.	Ubicación (Ciudad)
g.	Realizar la venta de una propiedad
h.	Realizar el alquiler de una propiedad
i.	Realizar la permuta de dos propiedades

3.	Desarrollar los siguientes casos de prueba en Junit.
a.	queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria
b.	queSePuedanDarDeAltaDosCasasEnLaInmobiliaria

c.	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria

d.	queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria

e.	queSePuedaObtenerElValorPromedioDeLasCasas

f.	queSePuedaObtenerElValorPromedioDeLosDepartamentos

g.	queSePuedaAgregarUnClienteALaInmobiliaria

h.	queNoSePuedanAgregarDosClientesConUnMismoDni

i.	queSePuedaRealizarLaVentaDeUnaPropiedad

j.	queSePuedaRealizarElAlquilerDeUnaPropiedad

k.	queSePuedaRealizarLaPermutaDeDosPropiedades

l.	queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio

m.	queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion

n.	queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio

o.	queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion

p.	queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException

q.	queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException

