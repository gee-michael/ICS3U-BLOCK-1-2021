var wordsOfWisdom = [
    "I am a sentence.",
    "Some nice stuff.",
    "I am random too!"
];
var wisdom = Math.floor(wordsOfWisdom.length * Math.random());
document.getElementById('wisdomWords').innerHTML = wordsOfWisdom[wisdom];
//document.write(wordsOfWisdom[wisdom]);


