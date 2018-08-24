$(document).ready(function() {
    // set language
    $('.header-top-right .select ul.language li').click(function () {

        var existValueLanguage = $('.select p span.display-language').text();
        if(this.innerText != existValueLanguage){
            $('.select p span.display-language').text(this.innerText);
        }
    });

    // set currency
    $('.header-top-right .select ul.currency li').click(function () {

        var existValueCurrency = $('.select p span.display-currency').text();
        if (this.innerText != existValueCurrency){
            $('.select p span.display-currency').text(this.innerText);
        }
    });
});