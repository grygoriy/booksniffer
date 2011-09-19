/**
 * Created by IntelliJ IDEA.
 * User: grygoriy
 * Date: 9/18/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function() {

    $('.click').click(function() {
         $.getJSON('checkByIsbn', {isbn:$('#isbn').val()}, function(data){
              $('#title').val(data.title);
              $('#author').val(data.authors);
              $('#publisher').val(data.publisher);
              $('#summary').text(data.summary);
         });
    });
});