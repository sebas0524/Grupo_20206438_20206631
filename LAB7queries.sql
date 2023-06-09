#En la lista se mostrará el ID, nombre, edad, posición, club y nombre de selección a la que corresponde.
#Además, la página debe incluir un botón para ir al registro de jugadores.

select * from jugador j 
inner join seleccion s on j.sn_idSeleccion = s.idSeleccion;


#CREAR JUGADOR: Se deben registrar y validar los siguientes campos:
#Nombre: requerido
#Edad: requerido y que sea número
#Posición: requerido
#Club: requerido
#Selección: requerido, usar combobox
#NOTA: Además, validar que no se repita el nombre del jugador dentro de una misma selección.
#Si el registro es válido, redirigir a la lista de jugadores. De lo contrario, volver a la página de
#registro.







#En la lista se mostrará el ID, nombre, tecnico, estadio, y primer partido* al que corresponde. Debe realizarse con una sola query.
#*Para buscar el primer partido, debe buscar los partidos de la selección (ya sea local o visitante), 
#ordenarlos por fecha y obtener el primero. En la lista, el primer partido se debe ver con este formato:
#seleccionLocal vs seleccionVisitante






use lab7;
#SELECCIONES
select s.idSeleccion, s.nombre, s.tecnico, e.nombre, concat(sl.nombre," vs ",sv.nombre) from seleccion s
inner join estadio e on s.estadio_idEstadio = e.idEstadio
inner join partido p on p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion
inner join seleccion sl on sl.idSeleccion = p.seleccionLocal
inner join seleccion sv on sv.idSeleccion = p.seleccionVisitante
order by p.fecha asc;
select * from partido;


select * from partido p order by fecha asc;











