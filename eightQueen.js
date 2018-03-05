


(function() {
    // todo here
    var map = [[0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0]],
        raw = [[0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0, 0, 0, 0]],
        set = [];

    var setting = function(x, y) {
        let $set = [];
        let $_ = map[x];
        for (let i = 0; i < 8; i ++) {
            if ($_[i] == 0) {
                map[x][i] = 2;
                $set.push([x, i]);
            }
        }

        for (let i = 0; i < 8; i ++) {
            if (map[i][y] == 0) {
                map[i][y] = 2;
                $set.push([i, y]);
            }
        }

        let $x = x, $y = y;
        while ($x > 0 && $y > 0) {
            $x --;
            $y --;
        }
        while ($x < 8 && $y < 8) {
            if (map[$x][$y] == 0) {
                map[$x][$y] = 2;
                $set.push([$x, $y]);
            }
            $x ++;
            $y ++;
        }

        $x = x, $y = y;
        while ($x > 0 && $y < 7) {
            $x --;
            $y ++;
        }

        while ($x < 8 && $y < 8) {
            if (map[$x][$y] == 0) {
                map[$x][$y] = 2;
                $set.push([$x, $y]);
            }
            $x ++;
            $y --;
        }

        set[x] = $set;


    };

    var clean = function(x) {
        let $set = set[x];
        if ($set) {
            for(let i = 0; i < $set.length; i ++) {
                map[$set[i][0]][$set[i][1]] = 0;
            }
        }
        set[x] = null;
    };

    var back = function(x) {
        let $x = (x - 1) < 0 ? 0 : (x - 1);
        $$j = $x;
        let $y = 0;
        clean($x);
        let row = map[$x];
        for (let i = 0; i < 8; i ++) {
            if (row[i] == 1) {
                row[i] = 0;
                $y = i + 1;
                break;
            }
        }
        if ($y >= 8) {
            back($x);
        }
        eq($x, $y);
    };

    var eq = function(x, y) {
        let had = 0;
        let row = map[x];
        for (let i = y; i < 8; i ++) {
            if (row[i] == 0) {
                had = 1;
                map[x][i] = 1;
                setting(x, i);
                break;
            }
        }
        if (!had) {
            back(x);
        }
    };

    //debugger;
    let $$j = 0;
    for (; $$j < 8; $$j ++) {
       eq($$j, 1);
    }
    // var run = function($$x) {
    //     console.log($$x);
    //     if ($$x >= 8) {
    //         console.log('not found');
    //         return;
    //     }
    //     for (; $$j < 8; $$j ++) {
    //         eq($$j, $$j == 0 ? $$x : 1);
    //     }
    //     for (let $$i = 0; $$i < 8; $$i ++) {
    //         let find = 0;
    //         let row = map[$$i];
    //         for (let $$y = 0; $$y < 8; $$y ++) {
    //             if (row[$$y] == 1) {
    //                 find = 1;
    //                 break;
    //             }
    //         }
    //         if (!find) {
    //             $$j = 0;
    //             map = raw;
    //             run($$x + 1);
    //             break;
    //         }

    //         console.log(map);
    //     }
        
    // };

    // run(0);
    
    console.log(map);

})();



