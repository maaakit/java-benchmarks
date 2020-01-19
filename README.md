# java-benchmarks

<pre>
empty loop:                      ONE             6935700 ns
arrayByFor:                      ONE             8281400 ns
arrayByStream:                   ONE           459421000 ns
arrayByStream func:              ONE           439538600 ns
empty loop:                      TEN            10596700 ns
arrayByFor:                      TEN           271221700 ns
arrayByStream:                   TEN           603336800 ns
arrayByStream func:              TEN           628222200 ns

empty loop:                      ONE             6428200 ns
setInternByFor:                  ONE           170904400 ns
setInternByStream:               ONE           486394800 ns
setInternStream func:            ONE           453310300 ns
empty loop:                      TEN             3151100 ns
setInternByFor:                  TEN           246631600 ns
setInternByStream:               TEN           894443100 ns
setInternStream func:            TEN           840199300 ns

empty loop:                      ONE             6377000 ns
setByFor:                        ONE           296717000 ns
setByStream:                     ONE           601863900 ns
setByStream func:                ONE           649127500 ns
empty loop:                      TEN             3139700 ns
setByFor:                        TEN           121927100 ns
setByStream:                     TEN           441798100 ns
setByStream func:                TEN           477588800 ns

empty loop:                      ONE             6302600 ns 
enumByFor == :                   ONE            10470000 ns 
enumByForEquals:                 ONE            10242100 ns 
enumByStream == :                ONE           474995100 ns 
enumByStreamEquals:              ONE           450236200 ns 
enumByStream func == :           ONE           363552500 ns 
enumByStream func equals:        ONE           357381300 ns 
empty loop:                      TEN             2350800 ns 
enumByFor == :                   TEN            97853800 ns 
enumByForEquals:                 TEN           122376800 ns 
enumByStream == :                TEN           692953800 ns 
enumByStreamEquals:              TEN           705611800 ns 
enumByStream func == :           TEN           726545600 ns 
enumByStream func equals:        TEN           702313900 ns 
</pre>
