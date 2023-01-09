cargarListadoMangas();
let indice;
$("body").on("click", ".enlace", function(){
     indice = $(this).find('input').val();
      cargarDatosManga(indice);
});
$("body").on("click",".enlaces ",function(event) {
  let posicion= $(this).find('input').val();
  actualizarFechaEnlace(posicion);
});
$("#btnInicio").click(function(){
		cargarListadoMangas();
});
async function cargarListadoMangas(){
    const request = await fetch('/Datos-Mangas', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
  }
    });
    const content = await request.json();
    let listado = '';
  for(let datosManga of content){
    let datos = '<div class="col-sm-2 col-6">'
     +'<a href="#" class="enlace">'
      +'<input class="" type="hidden" value="'+datosManga.id+'">'
     +' <div class="row text-light ">'
      +'<img class="container-sm" src="'+datosManga.foto+' alt="">'
      +'</div>'
      +'<div class="row">'
      +'<h2 class="d-flex text-light justify-content-center">'+datosManga.nombre+'</h2>'
      +'</div>'
      +'<div class="row">'
      +'<h3 class="d-flex text-light justify-content-center">Ultimo Capitulo Leido: '+datosManga.ultimoCapLeido+'</h3>'
      +'</div>'
      +'</a>'
      +'</div>'
  listado += datos;
  }
    $("#contenido").html(listado);
}

function cargarDatosManga(indice){
fetch('/Obtener-Datos/'+indice, {
     method: "GET"
   })
     .then((response) => response.json())
     .then((response) => {
        let listado = '';
        let contenido = '<div class="col-sm-2 col-6" id="enlacesManga">'
                        +'<div class="row text-light">'
                      +'<img class="imagenManga container-fluid" src="'+response.foto+'"alt=""/>'
                       +' </div>'
                    +'<div class="row">'
                      +'<h2 class="d-flex text-light justify-content-center titulo">'+response.nombre+'</h2>'
                    +'</div>'
                    +'<div class="row">'
                    +'<h2 class="d-flex text-light justify-content-center titulo">Ultimo Cap Leido: '+response.ultimoCapLeido+'</h2>'
                    +'</div>'
                    +'</div>';
        listado+=contenido;
        $("#contenido").html(listado);
        cargarEnlaces(indice);
     });

}

function cargarEnlaces(indice){
let listado = '';
fetch('/Obtener-Enlaces/'+indice, {
    method: "GET"
  })
    .then((response) => response.json())
    .then((response) => {
    for(let enlacesManga of response){
                let contenidoNuevo = '<div class="row enlaces d-flex justify-content-center">'
                                            +'<input type="hidden" name="" value="'+enlacesManga.id+'">'
                                            +'<a class="link" title="Titulo enlace" href="'+enlacesManga.enlace+'" target="_blank">enlace</a>'
                                            +'<p>Ultima vez leido: '+enlacesManga.fechalectura+'</p>'
                                       +'</div>';
                listado+=contenidoNuevo;
        }
        $("#enlacesManga").append(listado);
    });

}
function actualizarFechaEnlace(id){
fetch('/Actualizar-Fecha/'+id, {
     method: "PUT"
   })
     .then((response) => {
     cargarDatosManga(indice);
     });
}