/**
 * 
 */


//Genera calendario para sus campos requeridos
function calendario(idCaja) {
    $(idCaja).datepicker({format: "dd-mm-yyyy"});
}
;


//VENTANA MODAL //
function nVentana(hoja, tit, ancho) {
    //$('.modal-content').css('width', ancho);
    $("#myModalLabel").html(tit);
    var url = hoja;
    $("#modal-body-gen").html('<iframe class="embed-responsive-item" width="100%" height="450px" frameborder="0" scrolling="yes" src="' + url + '"></iframe>');
    $('#myModal22').modal({
        keyboard: true,
        backdrop: 'static',
        show: true
    });
}
;
function cierra() {
    $('#myModal22').modal('hide');
}
;

/*JQGRID REPONSIBE*/
function responsive_jqgrid(jqgrid) {
    jqgrid.find('.ui-jqgrid').addClass('clear-margin span12').css('width', '');
    jqgrid.find('.ui-jqgrid-view').addClass('clear-margin span12').css('width', '');
    jqgrid.find('.ui-jqgrid-view > div').eq(1).addClass('clear-margin span12').css('width', '').css('min-height', '0');
    jqgrid.find('.ui-jqgrid-view > div').eq(2).addClass('clear-margin span12').css('width', '').css('min-height', '0');
    jqgrid.find('.ui-jqgrid-sdiv').addClass('clear-margin span12').css('width', '');
    jqgrid.find('.ui-jqgrid-pager').addClass('clear-margin span12').css('width', '');
}


$('#confirm-delete').on('show.bs.modal', function(e) {
    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));

    $('.debug-url').html('Borrar <strong>' + $(this).find('.btn-ok').attr('title') + '</strong>');
});
 