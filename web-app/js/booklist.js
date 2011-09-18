/**
 * Created by IntelliJ IDEA.
 * User: grygoriy
 * Date: 9/18/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function() {
    var pages = $('#pages').val();
    $('#pagination').html('');
    for (var i = 1; i <= pages; i++) {
        $('#pagination').append("<li><a  href='javascript:void(0)'>" + i + "</a> </li>")
    }
});