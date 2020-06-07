const ajaxService = (function(){

    function getAjax(url,data,success,fail) {
        $.ajax({
            type: "GET",
            url: url,
            data : data,
            dataType: 'json',
            async : false,
            fail : fail
        }).done(function (result) {
            success(result)
        })
    }
    function postAjax(url,data,succses1,fail){
        $.ajax({
            type: "POST",
            url: url,
            data : data,
            dataType: 'json',
            async : false,
            fail : fail
        }).done(function (result) {
            success(result)
        })
    }    

    return {
        getAjax : getAjax
    };

})();


class URL {

    constructor(commonURL) {
        this.commonURL = commonURL;
    }

    get(value) {
        return this.commonURL + value;
    }
    
}