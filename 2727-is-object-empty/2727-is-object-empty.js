/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    // if(Object.keys(obj).length > 0){
    //     return false;
    // }
    // return true;
    return Object.keys(obj).length === 0;
};