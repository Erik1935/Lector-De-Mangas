 let idManga = 0;
 let idEnlace = 0;
 cargarDatos();

$("#btnNuevoManga").on('click', function(event) {
   registrarManga();

});

$("#btnActualizar").on('click', function(event) {
 actualizarDatosManga();
});

$("#nuevoEnlace").on('click', function(event) {
   registrarEnlace();
});
$("#btnBorrar").on('click', function(event) {
   borrarDatosManga();
   console.log("borrando");
});
$("#borrarEnlace").on('click', function(event) {
   borrarEnlace();
   console.log("borrando enlace");
});

$("#actualizarEnlace").on('click', function(event) {
   actualizarTextoEnlace();
});

$(document).on('change', '#floatingSelectGrid', function(event) {
     let valor = $("#floatingSelectGrid option:selected").val();
     console.log(valor+" Nombre seleccionado");
     mostrarEnlaces(valor);
     idManga = valor;
     obtenerDatosManga();
});

$(document).on('change', '#listaEnlaces', function(event) {
     let link = $("#listaEnlaces option:selected").text();
     idEnlace = $("#listaEnlaces option:selected").val();
     console.log(link+" Enlace seleccionado");
     $("#enlaceEditado").val(link);
});
function registrarManga(){
    let datos = {};
    datos.nombre = document.getElementById('nombre').value;
     datos.foto = document.getElementById('enlace').value;
      datos.ultimoCapLeido = document.getElementById('ultimoCapLeido').value;
      fetch('/Guardar-Mangas', {
        method: "POST",
        body: JSON.stringify(datos),
        headers: {"Content-type": "application/json; charset=UTF-8"}
      })
      .then(json => {
        cargarDatos();
        nuevo.reset();
      });


}
function registrarEnlace(){
let identificador = {};
identificador.id = idManga;//Obtenemos el id del manga el cual queremos agregar el enlace
 let link = {};
     link.enlace = document.getElementById('textoEnlace').value;
      link.fechalectura = fechaActual();
      link.id_manga = identificador;
      console.log(link);
      fetch('/Guardar-Enlace', {
        method: "POST",
        body: JSON.stringify(link),
        headers: {"Content-type": "application/json; charset=UTF-8"}
      })
      .then(response => response.json())
      .then(json => {
        cargarDatos();
        mostrarEnlaces(idManga);
        console.log("Exito Con el enlace");
      });
       console.log("Exito Con el enlace");
      nuevo.reset();
}
function cargarDatos(){
fetch('/Datos-Mangas', {
    method: "GET"
  })
    .then((response) => response.json())
    .then((response) => {
        console.log(response+" Datos--");
      let listado = ' <option selected ="selected"></option>';
    for(let datosManga of response){
      let datos = '<option value = "'+datosManga.id+'">'+datosManga.nombre+'</option>';
    listado += datos;
    }
      //console.log(content);
      $("#floatingSelectGrid").html(listado);
    });//---------------------
}

function mostrarEnlaces(id){
let listado = '';
fetch('/Obtener-Enlaces/'+id, {
    method: "GET"
  })
    .then((response) => response.json())
    .then((response) => {
        console.log(response+"Enlaces--");
   let listado = ' <option selected ="selected">Seleccione un enlace</option>';
    for(let enlacesManga of response){
      let datos = '<option value = "'+enlacesManga.id+'">'+enlacesManga.enlace+'</option>';
    listado += datos;
    }

      $("#listaEnlaces").html(listado);
    });

}
function fechaActual(){
let hoy = new Date();
let fecha =  hoy.getFullYear() + '-' +( hoy.getMonth() + 1 ) + '-' +hoy.getDate() ;
let hora = hoy.getHours() + ':' + hoy.getMinutes() + ':' + hoy.getSeconds();
return fecha +" "+ hora;
}
function obtenerDatosManga(){
fetch("/Obtener-Datos/"+idManga, {
     method: "GET"
   })
     .then((response) => response.json())
     .then((response) => {
     $("#nombreActualizado").val(response.nombre);
     $("#enlaceActualizado").val(response.foto);
     $("#numeroCapituloActualizado").val(response.ultimoCapLeido);
     });
}
function actualizarDatosManga(){
    let datosmanga = {};
        datosmanga.nombre = $("#nombreActualizado").val() ;
        datosmanga.foto =  $("#enlaceActualizado").val();
        datosmanga.ultimoCapLeido =  $("#numeroCapituloActualizado").val();
    fetch("/Actualizar-Datos-Mangas/"+idManga, {
        method: "PUT",
         body: JSON.stringify(datosmanga),
         headers: {"Content-type": "application/json; charset=UTF-8"}
             })
                .then((response) => {
         cargarDatos();
         $("#nombreActualizado").val("");
         $("#enlaceActualizado").val("");
         $("#numeroCapituloActualizado").val("");
        });
}
function borrarDatosManga(){
if(!(idManga == 0)){
fetch("/Borrar-Manga/"+idManga, {
        method: "DELETE",
         headers: {"Content-type": "application/json; charset=UTF-8"}
             })
                .then((response) => {
                //Reiniciar los cuadros de texto
                borrarTexto();

        });
}
}
function borrarEnlace(){
if(!(idEnlace == 0)){
    fetch("/Borrar-Enlace/"+idEnlace, {
        method: "DELETE",
         headers: {"Content-type": "application/json; charset=UTF-8"}
             })
                .then((response) => {
                //Reiniciar los cuadros de texto
                mostrarEnlaces(idManga);
                $("#enlaceEditado").val("");

        });
        }
}
function actualizarTextoEnlace(){
let identificador = {};
identificador.id = idManga;//Obtenemos el id del manga el cual queremos agregar el enlace
 let link = {};
     link.enlace = document.getElementById('enlaceEditado').value;
      link.fechalectura = fechaActual();
      link.id_manga = identificador;
fetch("/Actualizar-Enlace/"+idEnlace, {
        method: "PUT",
        body: JSON.stringify(link),
         headers: {"Content-type": "application/json; charset=UTF-8"}
             })
                .then((response) => {
                //Reiniciar los cuadros de texto
                mostrarEnlaces(idManga);
                $("#enlaceEditado").val("");

        });

}
function borrarTexto(){
 $("#nombreActualizado").val("");
 $("#enlaceActualizado").val("");
 $("#numeroCapituloActualizado").val("");
 let datos = '<option>Seleccione un Manga</option>';
 $("#listaEnlaces").html(datos);
 $("#enlaceEditado").html("");
  cargarDatos();
}


