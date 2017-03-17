/**
 * Get Ajax
 * @param url
 * @param options
 * @param callback
 */
function ajaxGet(url, options, callback) {
    $.ajax({
        url: url,
        data: options,
        async: true,
        dataType: 'json',
        type: 'GET',
        timeout: 5000,
        success: callback
    });
}

/**
 * Post Ajax
 * @param url
 * @param options
 * @param callback
 */
function ajaxPost(url, options, callback) {
    $.ajax({
        url: url,
        data: options,
        async: true,
        dataType: 'json',
        type: 'POST',
        timeout: 500000,
        success: callback
    });
}


/**
 * 时间格式转换
 * @param value
 * @param length
 * @returns {string}
 */
var zeroize = function (value, length) {
    if (!length) length = 2;
    value = String(value);
    for (var i = 0, zeros = ''; i < (length - value.length); i++) {
        zeros += '0';
    }
    return zeros + value;
};
var format_date = function (strTime) {
    var date = new Date(strTime);
    return date.getFullYear() + "-" + zeroize(date.getMonth() + 1) + "-" + zeroize(date.getDate()) + " " + zeroize(date.getHours()) + ":" + zeroize(date.getMinutes()) + ":" + zeroize(date.getSeconds());
};