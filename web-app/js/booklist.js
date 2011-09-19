/**
 * Created by IntelliJ IDEA.
 * User: grygoriy
 * Date: 9/18/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function() {

    $('ul#pagination li a').click(function() {
        getPageData($(this).text())
    });


    function getPageData(page) {
         $.getJSON('book/booksonpage', {page: page}, function(data){
             $('table#bookList').html('')
              $.each(data, function(i, result) {
                  $('table#bookList').append(
                            '<tr>' +
                            '<td class="isbnRow">' + result.isbn + '</td>' +
                            '<td class="titleRow">' + result.title + '</td>' +
                            '<td class="languageRow">' + result.language + '</td>' +
                            '<td class="editRow"><a htref="book/edit/' + result.BookId + '">' + $("#editValue").val() + ' </a></td>' +
                            '<td class="deleteRow"><a htref="book/delete/' + result.BookId + '">' + $("#deleteValue").val() + ' </a></td>' +
                            '</tr>')
              });
         });

    }
});