(function ($) {
    $.fn.material_chip = function(options) {
        var self = this;
        this.$el = $(this);
        this.$document = $(document);
        this.ID = Materialize.guid();
       
        var chipsHandleEvents = false;
        var materialChipsDefaults = {
        
          data: [],
          placeholder: '',
          secondaryPlaceholder: '',
          inputTextId:this.ID,
          inputHiddenId: 'InputTaggyHidden',
          seperator: ',',
          useOwnInputText:true,
          inputDataInvaildError:'invalid data!',
          inputDataCopyError:'doublicate data!',
          useIdFromSiblingsInputHidden:false,
          onStartLoadFunc:function(){},
          onStopLoadFunc:function(){}
        };
        var curr_options = $.extend({}, materialChipsDefaults, options);
        if(curr_options.inputTextId != self.ID)
        	self.ID = curr_options.inputTextId;
        this.SELS = {
                  CHIPS: '.chips',
                  CHIP: '.chip',
                  COPYBUTTON :'chips-copyAll',
                  INPUT: "#"+self.ID + "[type='text']",
                  DELETE: '.material-icons',
                  REMOVE_ALL :'.chips-removeAll',
                  COPY_ALL : '.chips-copyAll',
                  SELECTED_CHIP: '.selected',
                  Error_Place:'.chips-error'
                };
       
       
        this.init = function() {
            var i = 0;
            var chips;
            self.$el.each(function(){
              var $chips = $(this);
              var chipId = self.ID;

              if (!curr_options.data || !(curr_options.data instanceof Array)) {
                curr_options.data = [];
              }
              $chips.data('chips', curr_options.data);
              $chips.attr('data-index', i);
              $chips.attr('data-initialized', true);

              if (!$chips.hasClass(self.SELS.CHIPS)) {
                $chips.addClass('chips');
              }
             
              self.chips($chips, chipId);    
             
              i++;
            });
            self.handleEvents();
          };
       

         
          this.handleEvents = function(){
              var SELS = self.SELS;

             self.$el.on('click.chips-focus', function(e){
                $(e.target).find(SELS.INPUT).focus();
              });

             self.$el.on('click.chips-select', SELS.CHIP, function(e){
                $(SELS.CHIP).removeClass('selected');
                $(this).toggleClass('selected');
              });

             self.$document.off('keydown.chips').on('keydown.chips', function(e){
                if ($(e.target).is('input, textarea')) {
                  return;
                }

                // delete
                var $chip = self.$document.find(SELS.CHIP + SELS.SELECTED_CHIP);
                var $chips = $chip.closest(SELS.CHIPS);
                var length = $chip.siblings(SELS.CHIP).length;
                var index;

                if (!$chip.length) {
                  return;
                }

                if (e.which === 8 || e.which === 46) {
                  e.preventDefault();

                  index = $chip.index();
                  self.deleteChip(index, $chips);

                  var selectIndex = null;
                  if ((index + 1) < length) {
                    selectIndex = index;
                  } else if (index === length || (index + 1) === length) {
                    selectIndex = length - 1;
                  }

                  if (selectIndex < 0) selectIndex = null;

                  if (null !== selectIndex) {
                    self.selectChip(selectIndex, $chips);
                  }
                  if (!length) $chips.find("input[type='text']").focus();

                // left
                } else if (e.which === 37) {
                  index = $chip.index() - 1;
                  if (index < 0) {
                    return;
                  }
                  $(SELS.CHIP).removeClass('selected');
                  self.selectChip(index, $chips);

                // right
                } else if (e.which === 39) {
                  index = $chip.index() + 1;
                  $(SELS.CHIP).removeClass('selected');
                  if (index > length) {
                    $chips.find("input[type='text']").focus();
                    return;
                  }
                  self.selectChip(index, $chips);
                }
              });
             $(self.SELS.INPUT).on('focusin.chips', function(e){
                 var $currChips = $(e.target).closest(SELS.CHIPS);
                 $currChips.addClass('focus');
                 $currChips.siblings('label, .prefix').addClass('active');
                 $(SELS.CHIP).removeClass('selected');
               });
             $(self.SELS.INPUT).on('focusout.chips',function(e){
                 var $currChips = $(e.target).closest(SELS.CHIPS);
                 $currChips.removeClass('focus');

                 // Remove active if empty
                 if (!$currChips.data('chips').length) {
                   $currChips.siblings('label').removeClass('active');
                 }
                 $currChips.siblings('.prefix').removeClass('active');       
               });
             // customize by shk remove all by click on remove all button
             $(SELS.REMOVE_ALL).on('click.chips-removeAll', function(e){
                 var $target = $(e.target);
                 var $chips = $target.siblings(SELS.CHIPS);
                 self.deleteAllChips($chips);
                 self.removeInputHidden($chips);
               });
             $(SELS.COPY_ALL).on('click.chips-copyAll', function(e){
                 var $target = $(e.target);
                 var $chips = $target.siblings(SELS.CHIPS).find(SELS.CHIP);
                 $chips.not('selected').addClass('selected');
                    
                     self.selectionTextBeforeCopy($chips.filter('.chip.selected'));
                     $chips.find(SELS.INPUT).blur();
                     document.execCommand('Copy');
               });                      
            
             // SOME CODE MISSING HERE
            
            
             $(self.SELS.INPUT).on('blur.chips-add', function(e){
                 var $target = $(e.target);
                 var $chips = $target.closest(SELS.CHIPS);
                 if(curr_options.useIdFromSiblingsInputHidden)
                 {
                     if($target.siblings("input[type='hidden']").val()!="")
                     {
                         self.splitHiddenText($target.val(),$chips,$target.siblings("input[type='hidden']").val());
                         $target.siblings("input[type='hidden']").val("");
                         $target.attr("placeholder","");
                     }
                     else if($target.val()!="")
                     {
                         $chips.find(".chips-error").html(curr_options.inputDataInvaildError).show();
                     }
                     $target.val('');
                 }
                 else
                 {
                     var status = self.splitInputText($target.val(),$chips);
                     if(status != -1)
                    	 $target.val('');
                 }
                 //console.log($target.closest(SELS.CHIPS));

             });
            
             $(self.SELS.INPUT).on('keydown.chips-add', function(e){
                 var $target = $(e.target);
                 var $chips = $target.closest(SELS.CHIPS);
                 var chipsLength = $chips.children(SELS.CHIP).length;
                 // enter or seperator charatcter
                 if (curr_options.seperator.charCodeAt(0) === e.which || 13 === e.which) {
                   e.preventDefault();
                   if(curr_options.useIdFromSiblingsInputHidden)
                   {
                       if($target.siblings("input[type='hidden']").val()!="")
                       {
                           self.splitHiddenText($target.val(),$chips,$target.siblings("input[type='hidden']").val());
                           $target.siblings("input[type='hidden']").val("");
                           $target.attr("placeholder","");
                       }
                       else if($target.val()!="")
                       {
                           $chips.find(".chips-error").html(curr_options.inputDataInvaildError).show();
                       }
                	   $target.val('');

                   }
                   else
                   {
                       var status = self.splitInputText($target.val(),$chips);
                       if(status != -1)
                    	   $target.val('');
                   }
                   return;
                 }
                
                
                 // delete or left
                  if ((8 === e.keyCode || 37 === e.keyCode) && '' === $target.val() && chipsLength) {
                   e.preventDefault();
                   self.selectChip(chipsLength - 1, $chips);
                   $target.blur();
                   return;
                 }
                 
               });
            
             // select all chips by ctrl + all
             $(self.SELS.INPUT).on('keyup.chips-select', function(e){
                 if((e.ctrlKey && e.which == 65) || (e.ctrlKey && e.which == 97))
                 {
                	 var $target = $(e.target);
                	   $target.closest(SELS.CHIPS).find(SELS.CHIP).not('selected').addClass('selected');
                       var $chips = $target.closest(SELS.CHIPS).children(".chip.selected");
                       self.selectionTextBeforeCopy($chips);
                       $target.blur();
                 }
             });

             // Click on delete icon in chip.
             self.$document.off('click.chips-delete', SELS.CHIPS + ' ' + SELS.DELETE).on('click.chips-delete', SELS.CHIPS + ' ' + SELS.DELETE, function(e) {
               var $target = $(e.target);
               var $chips = $target.closest(SELS.CHIPS);
               var $chip = $target.closest(SELS.CHIP);
               e.stopPropagation();
               self.deleteChip($chip.index(), $chips);
               $chips.find("input[type='text']").focus();
             });
            
            };
       

        //customize by shk split text function
        this.splitInputText = function(str,chips){
            // customization by shk add tags just with space
            if(str == "")
                return ;
            var splitedText = [];
            //console.log("splitText->str" + str);
            splitedText = str.split(curr_options.seperator);
            //customize shk for performance considerations
            if(splitedText.length<500)
            {
                curr_options.onStartLoadFunc();
                for(var i = 0 ; i < splitedText.length ; i++)
                {
                    self.addChip({tag: splitedText[i]}, chips);
                    //console.log("split text in loop: "+ splitedText[i]);
                }
                curr_options.onStopLoadFunc();
            }
            else  if(splitedText.length>500 && splitedText.length<800)
            {
                curr_options.onStartLoadFunc();
                function test(){
                    if(i>splitedText.length/150)
                    {
                        curr_options.onStopLoadFunc();
                        clearInterval(interval);
                    }
                    for(var j = i*150 ; j <i*150+150  ; j++)
                    {
                        self.addChip({tag: splitedText[j]}, chips);
                    }
                    i++;
                }
                var i=0;
                var interval = setInterval(test,0.000001);           
                //console.log("split text in loop: "+ splitedText[i]);
                   
            }
            else{
            	return -1;
            }
        };
        //customize by shk split text function when we have to use id and label together
        this.splitHiddenText = function(str,chips,strGuestHidden){
            // customization by shk add tags just with space
            var splitedText = [];
            var splitedHiddenId = [];
            //console.log("splitText->str" + str);
            splitedText = str.split(curr_options.seperator);
            splitedHiddenId = strGuestHidden.split(curr_options.seperator);
            //customize shk for performance considerations
            if(splitedText.length<500)
            {
                curr_options.onStartLoadFunc();
                for(var i = 0 ; i < splitedText.length &&  i < splitedHiddenId.length ; i++)
                {
                    self.addChip({tag: splitedText[i],id:splitedHiddenId[i]}, chips);
                    //console.log("split text in loop: "+ splitedText[i]);
                }
                curr_options.onStopLoadFunc();
            }
            else if(splitedText.length>500 && splitedText.length<800)
            {
                curr_options.onStartLoadFunc();
                function test(){
                    if(i>splitedText.length/150)
                    {
                        curr_options.onStopLoadFunc();
                        clearInterval(interval);
                    }
                    for(var j = i*150 ; j <i*150+150  ; j++)
                    {
                        self.addChip({tag: splitedText[i],id:splitedHiddenId[i]}, chips);
                    }
                    i++;
                }
                var i=0;
                var interval = setInterval(test,0.000001);           
                //console.log("split text in loop: "+ splitedText[i]);
                   
            }
        }       
        //set input hidden function
        this.setInputHidden = function($chips){
            var $chipsAddedText = "";
            if(curr_options.useIdFromSiblingsInputHidden)
            {
                for(var i = 0 ; i < self.$el.data('chips').size() ; i++)
                {
                    $chipsAddedText = $chipsAddedText ==""?self.$el.data('chips')[i].id:$chipsAddedText + curr_options.seperator + self.$el.data('chips')[i].id;
                }  
            }
            else
            {
                for(var i = 0 ; i < $chips.data('chips').size() ; i++)
                { 
                		if(i == 0)
                			$chipsAddedText += $chips.data('chips')[i].tag ;
                		else
                			$chipsAddedText += curr_options.seperator + $chips.data('chips')[i].tag ;
                }  
            }
            console.log(self);
            $chips.siblings().val($chipsAddedText);
        }
        this.removeInputHidden = function(elm){
            elm.siblings("#"+curr_options.inputHiddenId).val("");
        }       
        this.chips = function($chips, chipId) {
            var html = '';
            $chips.data('chips').forEach(function(elem){
              html += self.renderChip(elem);
            });
            if(curr_options.useOwnInputText)
            {
                html += '<input id="' + chipId +'" class="input" type="text" placeholder="">';
                $chips.html(html);
            }
            else
            {
                $chips.find("input[type='text']").addClass("input");
            }
            self.setPlaceholder($chips);

            // Set for attribute for label
            var label = $chips.next('label');
            if (label.length) {
              label.attr('for', chipId);

              if ($chips.data('chips').length) {
                label.addClass('active');
              }
            }
          };

          this.renderChip = function(elem) {
            if (!elem.tag) return;

            var html = '<div class="chip">' + elem.tag;
            if (elem.image) {
              html += ' <img src="' + elem.image + '"> ';
            }
            html += '<i class="icon-cancel material-icons close"></i>';
            html += '</div>';
            return html;
          };

          this.setPlaceholder = function($chips) {
            if ($chips.data('chips').length && curr_options.placeholder) {
              $chips.find('input[type="text"]').prop('placeholder', curr_options.placeholder);

            } else if (!$chips.data('chips').length && curr_options.secondaryPlaceholder) {
              $chips.find('input[type="text"]').prop('placeholder', curr_options.secondaryPlaceholder);
            }
          };

          this.isValid = function($chips, elem) {
            var chips = $chips.data('chips');
            var exists = false;
            for (var i=0; i < chips.length; i++) {
              if (chips[i].tag === elem.tag) {
                  exists = true;
                  return;
              }
            }
            return '' !== elem.tag && !exists;
          };

          this.addChip = function(elem, $chips) {
            if (!self.isValid($chips, elem)) {
                $chips.find(".chips-error").html(curr_options.inputDataCopyError).show();
               //console.log("addChip=");
              //console.log(elem.tag);
              //console.log("");
              return;
            }
            $chips.find(".chips-error").hide();
            var chipHtml = self.renderChip(elem);
            var newData = [];
            var oldData = $chips.data('chips');
            for (var i = 0; i < oldData.length; i++) {
               // console.log("oldData[i]:"+ oldData[i]);
                newData.push(oldData[i]);
            }
            newData.push(elem);

            $chips.data('chips', newData);
            $(chipHtml).insertBefore($chips.find('input[type="text"]'));
            $chips.trigger('chip.add', elem);
            self.setPlaceholder($chips);
            //set input hidden
            self.setInputHidden($chips);
          };

          this.deleteChip = function(chipIndex, $chips) {
            var chip = $chips.data('chips')[chipIndex];
            $chips.find('.chip').eq(chipIndex).remove();

            var newData = [];
            var oldData = $chips.data('chips');
            for (var i = 0; i < oldData.length; i++) {
              if (i !== chipIndex) {
                newData.push(oldData[i]);
              }
            }

            $chips.data('chips', newData);
            $chips.trigger('chip.delete', chip);
            self.setPlaceholder($chips);
            //set input hidden
            self.setInputHidden($chips);
          };

          //customize by shk delete all chips
          this.deleteAllChips = function($chips) {
              $chips.find('.chip').remove();
              $chips.data('chips','');
          };
          this.selectChip = function(chipIndex, $chips) {
            var $chip = $chips.find('.chip').eq(chipIndex);
            if ($chip && false === $chip.hasClass('selected')) {
              $chip.addClass('selected');
              $chips.trigger('chip.select', $chips.data('chips')[chipIndex]);
            }
          };
          this.selectionTextBeforeCopy = function($chips){
              var text = $chips;
              var selection = window.getSelection();
              selection.removeAllRanges();
              text.each(function(){
                   var range = document.createRange();       
                   range.selectNodeContents(this);       
                   selection.addRange(range);
              });
          };
          this.selectionTextAfterCopy = function(){
              var selection = window.getSelection();
              selection.removeAllRanges();
          };
          this.getChipsElement = function(index, $chips) {
            return $chips.eq(index);
          };

          // init
          this.init();
         

          if (!chipsHandleEvents) {
            this.handleEvents();
            chipsHandleEvents = true;
          }
    }
}( jQuery ));
