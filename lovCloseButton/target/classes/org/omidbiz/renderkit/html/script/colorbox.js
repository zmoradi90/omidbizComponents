// ColorBox v1.3.19 - jQuery lightbox plugin
// (c) 2011 Jack Moore - jacklmoore.com
// License: http://www.opensource.org/licenses/mit-license.php
(function (jQuery, document, window) {
    var
    // Default settings object.	
    // See http://jacklmoore.com/colorbox for details.
    defaults = {
        transition: "elastic",
        speed: 300,
        width: false,
        initialWidth: "600",
        innerWidth: false,
        maxWidth: false,
        height: false,
        initialHeight: "450",
        innerHeight: false,
        maxHeight: false,
        scalePhotos: true,
        scrolling: true,
        inline: false,
        html: false,
        iframe: false,
        fastIframe: true,
        photo: false,
        href: false,
        title: false,
        rel: false,
        opacity: 0.9,
        preloading: true,
        current: "image {current} of {total}",
        previous: "previous",
        next: "next",
        close: "close",
        open: false,
        returnFocus: true,
        reposition: true,
        loop: true,
        slideshow: false,
        slideshowAuto: true,
        slideshowSpeed: 2500,
        slideshowStart: "start slideshow",
        slideshowStop: "stop slideshow",
        onOpen: false,
        onLoad: false,
        onComplete: false,
        onCleanup: false,
        onClosed: false,
        overlayClose: true,		
        escKey: true,
        arrowKey: true,
        top: false,
        bottom: false,
        left: false,
        right: false,
        fixed: false,
        data: undefined
    },
	
    // Abstracting the HTML and event identifiers for easy rebranding
    colorbox = 'colorbox',
    prefix = 'cbox',
    boxElement = prefix + 'Element',
    
    // Events	
    event_open = prefix + '_open',
    event_load = prefix + '_load',
    event_complete = prefix + '_complete',
    event_cleanup = prefix + '_cleanup',
    event_closed = prefix + '_closed',
    event_purge = prefix + '_purge',
    
    // Special Handling for IE
    isIE = !jQuery.support.opacity && !jQuery.support.style, // IE7 & IE8
    isIE6 = isIE && !window.XMLHttpRequest, // IE6
    event_ie6 = prefix + '_IE6',

    // Cached jQuery Object Variables
    jQueryoverlay,
    jQuerybox,
    jQuerywrap,
    jQuerycontent,
    jQuerytopBorder,
    jQueryleftBorder,
    jQueryrightBorder,
    jQuerybottomBorder,
    jQueryrelated,
    jQuerywindow,
    jQueryloaded,
    jQueryloadingBay,
    jQueryloadingOverlay,
    jQuerytitle,
    jQuerycurrent,
    jQueryslideshow,
    jQuerynext,
    jQueryprev,
    jQueryclose,
    jQuerygroupControls,
    
    // Variables for cached values or use across multiple functions
    settings,
    interfaceHeight,
    interfaceWidth,
    loadedHeight,
    loadedWidth,
    element,
    index,
    photo,
    open,
    active,
    closing,
    loadingTimer,
    publicMethod,
    div = "div",
    init;

	// ****************
	// HELPER FUNCTIONS
	// ****************
    
	// Convience function for creating new jQuery objects
    function jQuerytag(tag, id, css) {
		var element = document.createElement(tag);

		if (id) {
			element.id = prefix + id;
		}

		if (css) {
			element.style.cssText = css;
		}

		return jQuery(element);
    }

	// Determine the next and previous members in a group.
	function getIndex(increment) {
		var 
		max = jQueryrelated.length, 
		newIndex = (index + increment) % max;
		
		return (newIndex < 0) ? max + newIndex : newIndex;
	}

	// Convert '%' and 'px' values to integers
	function setSize(size, dimension) {
		return Math.round((/%/.test(size) ? ((dimension === 'x' ? jQuerywindow.width() : jQuerywindow.height()) / 100) : 1) * parseInt(size, 10));
	}
	
	// Checks an href to see if it is a photo.
	// There is a force photo option (photo: true) for hrefs that cannot be matched by this regex.
	function isImage(url) {
		return settings.photo || /\.(gif|png|jpe?g|bmp|ico)((#|\?).*)?$/i.test(url);
	}
	
	// Assigns function results to their respective properties
	function makeSettings() {
        var i;
        settings = jQuery.extend({}, jQuery.data(element, colorbox));
        
		for (i in settings) {
			if (jQuery.isFunction(settings[i]) && i.slice(0, 2) !== 'on') { // checks to make sure the function isn't one of the callbacks, they will be handled at the appropriate time.
			    settings[i] = settings[i].call(element);
			}
		}
        
		settings.rel = settings.rel || element.rel || 'nofollow';
		settings.href = settings.href || jQuery(element).attr('href');
		settings.title = settings.title || element.title;
        
        if (typeof settings.href === "string") {
            settings.href = jQuery.trim(settings.href);
        }
	}

	function trigger(event, callback) {
		jQuery.event.trigger(event);
		if (callback) {
			callback.call(element);
		}
	}

	// Slideshow functionality
	function slideshow() {
		var
		timeOut,
		className = prefix + "Slideshow_",
		click = "click." + prefix,
		start,
		stop,
		clear;
		
		if (settings.slideshow && jQueryrelated[1]) {
			start = function () {
				jQueryslideshow
					.text(settings.slideshowStop)
					.unbind(click)
					.bind(event_complete, function () {
						if (settings.loop || jQueryrelated[index + 1]) {
							timeOut = setTimeout(publicMethod.next, settings.slideshowSpeed);
						}
					})
					.bind(event_load, function () {
						clearTimeout(timeOut);
					})
					.one(click + ' ' + event_cleanup, stop);
				jQuerybox.removeClass(className + "off").addClass(className + "on");
				timeOut = setTimeout(publicMethod.next, settings.slideshowSpeed);
			};
			
			stop = function () {
				clearTimeout(timeOut);
				jQueryslideshow
					.text(settings.slideshowStart)
					.unbind([event_complete, event_load, event_cleanup, click].join(' '))
					.one(click, function () {
						publicMethod.next();
						start();
					});
				jQuerybox.removeClass(className + "on").addClass(className + "off");
			};
			
			if (settings.slideshowAuto) {
				start();
			} else {
				stop();
			}
		} else {
            jQuerybox.removeClass(className + "off " + className + "on");
        }
	}

	function launch(target) {
		if (!closing) {
			
			element = target;
			
			makeSettings();
			
			jQueryrelated = jQuery(element);
			
			index = 0;
			
			if (settings.rel !== 'nofollow') {
				jQueryrelated = jQuery('.' + boxElement).filter(function () {
					var relRelated = jQuery.data(this, colorbox).rel || this.rel;
					return (relRelated === settings.rel);
				});
				index = jQueryrelated.index(element);
				
				// Check direct calls to ColorBox.
				if (index === -1) {
					jQueryrelated = jQueryrelated.add(element);
					index = jQueryrelated.length - 1;
				}
			}
			
			if (!open) {
				open = active = true; // Prevents the page-change action from queuing up if the visitor holds down the left or right keys.
				
				jQuerybox.show();
				
				if (settings.returnFocus) {
					jQuery(element).blur().one(event_closed, function () {
						jQuery(this).focus();
					});
				}
				
				// +settings.opacity avoids a problem in IE when using non-zero-prefixed-string-values, like '.5'
				jQueryoverlay.css({"opacity": +settings.opacity, "cursor": settings.overlayClose ? "pointer" : "auto"}).show();
				
				// Opens inital empty ColorBox prior to content being loaded.
				settings.w = setSize(settings.initialWidth, 'x');
				settings.h = setSize(settings.initialHeight, 'y');
				publicMethod.position();
				
				if (isIE6) {
					jQuerywindow.bind('resize.' + event_ie6 + ' scroll.' + event_ie6, function () {
						jQueryoverlay.css({width: jQuerywindow.width(), height: jQuerywindow.height(), top: jQuerywindow.scrollTop(), left: jQuerywindow.scrollLeft()});
					}).trigger('resize.' + event_ie6);
				}
				
				trigger(event_open, settings.onOpen);
				
				jQuerygroupControls.add(jQuerytitle).hide();
				
				jQueryclose.html(settings.close).show();
			}
			
			publicMethod.load(true);
		}
	}

	// ColorBox's markup needs to be added to the DOM prior to being called
	// so that the browser will go ahead and load the CSS background images.
	function appendHTML() {
		if (!jQuerybox && document.body) {
			init = false;

			jQuerywindow = jQuery(window);
			jQuerybox = jQuerytag(div).attr({id: colorbox, 'class': isIE ? prefix + (isIE6 ? 'IE6' : 'IE') : ''}).hide();
			jQueryoverlay = jQuerytag(div, "Overlay", isIE6 ? 'position:absolute' : '').hide();
			jQuerywrap = jQuerytag(div, "Wrapper");
			jQuerycontent = jQuerytag(div, "Content").append(
				jQueryloaded = jQuerytag(div, "LoadedContent", 'width:0; height:0; overflow:hidden'),
				jQueryloadingOverlay = jQuerytag(div, "LoadingOverlay").add(jQuerytag(div, "LoadingGraphic")),
				jQuerytitle = jQuerytag(div, "Title"),
				jQuerycurrent = jQuerytag(div, "Current"),
				jQuerynext = jQuerytag(div, "Next"),
				jQueryprev = jQuerytag(div, "Previous"),
				jQueryslideshow = jQuerytag(div, "Slideshow").bind(event_open, slideshow),
				jQueryclose = jQuerytag(div, "Close")
			);
			
			jQuerywrap.append( // The 3x3 Grid that makes up ColorBox
				jQuerytag(div).append(
					jQuerytag(div, "TopLeft"),
					jQuerytopBorder = jQuerytag(div, "TopCenter"),
					jQuerytag(div, "TopRight")
				),
				jQuerytag(div, false, 'clear:left').append(
					jQueryleftBorder = jQuerytag(div, "MiddleLeft"),
					jQuerycontent,
					jQueryrightBorder = jQuerytag(div, "MiddleRight")
				),
				jQuerytag(div, false, 'clear:left').append(
					jQuerytag(div, "BottomLeft"),
					jQuerybottomBorder = jQuerytag(div, "BottomCenter"),
					jQuerytag(div, "BottomRight")
				)
			).find('div div').css({'float': 'left'});
			
			jQueryloadingBay = jQuerytag(div, false, 'position:absolute; width:9999px; visibility:hidden; display:none');
			
			jQuerygroupControls = jQuerynext.add(jQueryprev).add(jQuerycurrent).add(jQueryslideshow);

			jQuery(document.body).append(jQueryoverlay, jQuerybox.append(jQuerywrap, jQueryloadingBay));
		}
	}

	// Add ColorBox's event bindings
	function addBindings() {
		if (jQuerybox) {
			if (!init) {
				init = true;

				// Cache values needed for size calculations
				interfaceHeight = jQuerytopBorder.height() + jQuerybottomBorder.height() + jQuerycontent.outerHeight(true) - jQuerycontent.height();//Subtraction needed for IE6
				interfaceWidth = jQueryleftBorder.width() + jQueryrightBorder.width() + jQuerycontent.outerWidth(true) - jQuerycontent.width();
				loadedHeight = jQueryloaded.outerHeight(true);
				loadedWidth = jQueryloaded.outerWidth(true);
				
				// Setting padding to remove the need to do size conversions during the animation step.
				jQuerybox.css({"padding-bottom": interfaceHeight, "padding-right": interfaceWidth});

				// Anonymous functions here keep the public method from being cached, thereby allowing them to be redefined on the fly.
				jQuerynext.click(function () {
					publicMethod.next();
				});
				jQueryprev.click(function () {
					publicMethod.prev();
				});
				jQueryclose.click(function () {
					publicMethod.close();
				});
				jQueryoverlay.click(function () {
					if (settings.overlayClose) {
						publicMethod.close();
					}
				});
				
				// Key Bindings
				jQuery(document).bind('keydown.' + prefix, function (e) {
					var key = e.keyCode;
					if (open && settings.escKey && key === 27) {
						e.preventDefault();
						publicMethod.close();
					}
					if (open && settings.arrowKey && jQueryrelated[1]) {
						if (key === 37) {
							e.preventDefault();
							jQueryprev.click();
						} else if (key === 39) {
							e.preventDefault();
							jQuerynext.click();
						}
					}
				});

				jQuery('.' + boxElement, document).live('click', function (e) {
			        // ignore non-left-mouse-clicks and clicks modified with ctrl / command, shift, or alt.
			        // See: http://jacklmoore.com/notes/click-events/
			        if (!(e.which > 1 || e.shiftKey || e.altKey || e.metaKey)) {
			            e.preventDefault();
			            launch(this);
			        }
			    });
			}
			return true;
		}
		return false;
	}

	// Don't do anything if ColorBox already exists.
	if (jQuery.colorbox) {
		return;
	}

	// Append the HTML when the DOM loads
	jQuery(appendHTML);


	// ****************
	// PUBLIC FUNCTIONS
	// Usage format: jQuery.fn.colorbox.close();
	// Usage from within an iframe: parent.jQuery.fn.colorbox.close();
	// ****************
	
	publicMethod = jQuery.fn[colorbox] = jQuery[colorbox] = function (options, callback) {
		var jQuerythis = this;
		
        options = options || {};
        
        appendHTML();

		if (addBindings()) {
			if (!jQuerythis[0]) {
				if (jQuerythis.selector) { // if a selector was given and it didn't match any elements, go ahead and exit.
	                return jQuerythis;
	            }
	            // if no selector was given (ie. jQuery.colorbox()), create a temporary element to work with
				jQuerythis = jQuery('<a/>');
				options.open = true; // assume an immediate open
			}
			
			if (callback) {
				options.onComplete = callback;
			}
			
			jQuerythis.each(function () {
				jQuery.data(this, colorbox, jQuery.extend({}, jQuery.data(this, colorbox) || defaults, options));
			}).addClass(boxElement);
			
	        if ((jQuery.isFunction(options.open) && options.open.call(jQuerythis)) || options.open) {
				launch(jQuerythis[0]);
			}
		}
        
		return jQuerythis;
	};

	publicMethod.position = function (speed, loadedCallback) {
        var 
        top = 0, 
        left = 0, 
        offset = jQuerybox.offset(),
        scrollTop = jQuerywindow.scrollTop(), 
        scrollLeft = jQuerywindow.scrollLeft();
        
        jQuerywindow.unbind('resize.' + prefix);

        // remove the modal so that it doesn't influence the document width/height        
        jQuerybox.css({top: -9e4, left: -9e4});

        if (settings.fixed && !isIE6) {
			offset.top -= scrollTop;
			offset.left -= scrollLeft;
            jQuerybox.css({position: 'fixed'});
        } else {
            top = scrollTop;
            left = scrollLeft;
            jQuerybox.css({position: 'absolute'});
        }

		// keeps the top and left positions within the browser's viewport.
        if (settings.right !== false) {
            left += Math.max(jQuerywindow.width() - settings.w - loadedWidth - interfaceWidth - setSize(settings.right, 'x'), 0);
        } else if (settings.left !== false) {
            left += setSize(settings.left, 'x');
        } else {
            left += Math.round(Math.max(jQuerywindow.width() - settings.w - loadedWidth - interfaceWidth, 0) / 2);
        }
        
        if (settings.bottom !== false) {
            top += Math.max(jQuerywindow.height() - settings.h - loadedHeight - interfaceHeight - setSize(settings.bottom, 'y'), 0);
        } else if (settings.top !== false) {
            top += setSize(settings.top, 'y');
        } else {
            top += Math.round(Math.max(jQuerywindow.height() - settings.h - loadedHeight - interfaceHeight, 0) / 2);
        }

        jQuerybox.css({top: offset.top, left: offset.left});

		// setting the speed to 0 to reduce the delay between same-sized content.
		speed = (jQuerybox.width() === settings.w + loadedWidth && jQuerybox.height() === settings.h + loadedHeight) ? 0 : speed || 0;
        
		// this gives the wrapper plenty of breathing room so it's floated contents can move around smoothly,
		// but it has to be shrank down around the size of div#colorbox when it's done.  If not,
		// it can invoke an obscure IE bug when using iframes.
		jQuerywrap[0].style.width = jQuerywrap[0].style.height = "9999px";
		
		function modalDimensions(that) {
			jQuerytopBorder[0].style.width = jQuerybottomBorder[0].style.width = jQuerycontent[0].style.width = that.style.width;
			jQuerycontent[0].style.height = jQueryleftBorder[0].style.height = jQueryrightBorder[0].style.height = that.style.height;
		}
		
		jQuerybox.dequeue().animate({width: settings.w + loadedWidth, height: settings.h + loadedHeight, top: top, left: left}, {
			duration: speed,
			complete: function () {
				modalDimensions(this);
				
				active = false;
				
				// shrink the wrapper down to exactly the size of colorbox to avoid a bug in IE's iframe implementation.
				jQuerywrap[0].style.width = (settings.w + loadedWidth + interfaceWidth) + "px";
				jQuerywrap[0].style.height = (settings.h + loadedHeight + interfaceHeight) + "px";
                
                if (settings.reposition) {
	                setTimeout(function () {  // small delay before binding onresize due to an IE8 bug.
	                    jQuerywindow.bind('resize.' + prefix, publicMethod.position);
	                }, 1);
	            }

				if (loadedCallback) {
					loadedCallback();
				}
			},
			step: function () {
				modalDimensions(this);
			}
		});
	};

	publicMethod.resize = function (options) {
		if (open) {
			options = options || {};
			
			if (options.width) {
				settings.w = setSize(options.width, 'x') - loadedWidth - interfaceWidth;
			}
			if (options.innerWidth) {
				settings.w = setSize(options.innerWidth, 'x');
			}
			jQueryloaded.css({width: settings.w});
			
			if (options.height) {
				settings.h = setSize(options.height, 'y') - loadedHeight - interfaceHeight;
			}
			if (options.innerHeight) {
				settings.h = setSize(options.innerHeight, 'y');
			}
			if (!options.innerHeight && !options.height) {
				jQueryloaded.css({height: "auto"});
				settings.h = jQueryloaded.height();
			}
			jQueryloaded.css({height: settings.h});
			
			publicMethod.position(settings.transition === "none" ? 0 : settings.speed);
		}
	};

	publicMethod.prep = function (object) {
		if (!open) {
			return;
		}
		
		var callback, speed = settings.transition === "none" ? 0 : settings.speed;
		
		jQueryloaded.remove();
		jQueryloaded = jQuerytag(div, 'LoadedContent').append(object);
		
		function getWidth() {
			settings.w = settings.w || jQueryloaded.width();
			settings.w = settings.mw && settings.mw < settings.w ? settings.mw : settings.w;
			return settings.w;
		}
		function getHeight() {
			settings.h = settings.h || jQueryloaded.height();
			settings.h = settings.mh && settings.mh < settings.h ? settings.mh : settings.h;
			return settings.h;
		}
		
		jQueryloaded.hide()
		.appendTo(jQueryloadingBay.show())// content has to be appended to the DOM for accurate size calculations.
		.css({width: getWidth(), overflow: settings.scrolling ? 'auto' : 'hidden'})
		.css({height: getHeight()})// sets the height independently from the width in case the new width influences the value of height.
		.prependTo(jQuerycontent);
		
		jQueryloadingBay.hide();
		
		// floating the IMG removes the bottom line-height and fixed a problem where IE miscalculates the width of the parent element as 100% of the document width.
		//jQuery(photo).css({'float': 'none', marginLeft: 'auto', marginRight: 'auto'});
		
        jQuery(photo).css({'float': 'none'});
        
		// Hides SELECT elements in IE6 because they would otherwise sit on top of the overlay.
		if (isIE6) {
			jQuery('select').not(jQuerybox.find('select')).filter(function () {
				return this.style.visibility !== 'hidden';
			}).css({'visibility': 'hidden'}).one(event_cleanup, function () {
				this.style.visibility = 'inherit';
			});
		}
		
		callback = function () {
            var preload, i, total = jQueryrelated.length, iframe, frameBorder = 'frameBorder', allowTransparency = 'allowTransparency', complete, src, img;
            
            if (!open) {
                return;
            }
            
            function removeFilter() {
                if (isIE) {
                    jQuerybox[0].style.removeAttribute('filter');
                }
            }
            
            complete = function () {
                clearTimeout(loadingTimer);
                jQueryloadingOverlay.hide();
                trigger(event_complete, settings.onComplete);
            };
            
            if (isIE) {
                //This fadeIn helps the bicubic resampling to kick-in.
                if (photo) {
                    jQueryloaded.fadeIn(100);
                }
            }
            
            jQuerytitle.html(settings.title).add(jQueryloaded).show();
            
            if (total > 1) { // handle grouping
                if (typeof settings.current === "string") {
                    jQuerycurrent.html(settings.current.replace('{current}', index + 1).replace('{total}', total)).show();
                }
                
                jQuerynext[(settings.loop || index < total - 1) ? "show" : "hide"]().html(settings.next);
                jQueryprev[(settings.loop || index) ? "show" : "hide"]().html(settings.previous);
				
                if (settings.slideshow) {
                    jQueryslideshow.show();
                }
				
                // Preloads images within a rel group
                if (settings.preloading) {
					preload = [
						getIndex(-1),
						getIndex(1)
					];
					while (i = jQueryrelated[preload.pop()]) {
						src = jQuery.data(i, colorbox).href || i.href;
						if (jQuery.isFunction(src)) {
							src = src.call(i);
						}
						if (isImage(src)) {
							img = new Image();
							img.src = src;
						}
					}
                }
            } else {
                jQuerygroupControls.hide();
            }
            
            if (settings.iframe) {
                iframe = jQuerytag('iframe')[0];
                
                if (frameBorder in iframe) {
                    iframe[frameBorder] = 0;
                }
                if (allowTransparency in iframe) {
                    iframe[allowTransparency] = "true";
                }
                // give the iframe a unique name to prevent caching
                iframe.name = prefix + (+new Date());
                if (settings.fastIframe) {
                    complete();
                } else {
                    jQuery(iframe).one('load', complete);
                }
                iframe.src = settings.href;
                if (!settings.scrolling) {
                    iframe.scrolling = "no";
                }
                jQuery(iframe).addClass(prefix + 'Iframe').appendTo(jQueryloaded).one(event_purge, function () {
                    iframe.src = "//about:blank";
                });
            } else {
                complete();
            }
            
            if (settings.transition === 'fade') {
                jQuerybox.fadeTo(speed, 1, removeFilter);
            } else {
                removeFilter();
            }
		};
		
		if (settings.transition === 'fade') {
			jQuerybox.fadeTo(speed, 0, function () {
				publicMethod.position(0, callback);
			});
		} else {
			publicMethod.position(speed, callback);
		}
	};

	publicMethod.load = function (launched) {
		var href, setResize, prep = publicMethod.prep;
		
		active = true;
		
		photo = false;
		
		element = jQueryrelated[index];
		
		if (!launched) {
			makeSettings();
		}
		
		trigger(event_purge);
		
		trigger(event_load, settings.onLoad);
		
		settings.h = settings.height ?
				setSize(settings.height, 'y') - loadedHeight - interfaceHeight :
				settings.innerHeight && setSize(settings.innerHeight, 'y');
		
		settings.w = settings.width ?
				setSize(settings.width, 'x') - loadedWidth - interfaceWidth :
				settings.innerWidth && setSize(settings.innerWidth, 'x');
		
		// Sets the minimum dimensions for use in image scaling
		settings.mw = settings.w;
		settings.mh = settings.h;
		
		// Re-evaluate the minimum width and height based on maxWidth and maxHeight values.
		// If the width or height exceed the maxWidth or maxHeight, use the maximum values instead.
		if (settings.maxWidth) {
			settings.mw = setSize(settings.maxWidth, 'x') - loadedWidth - interfaceWidth;
			settings.mw = settings.w && settings.w < settings.mw ? settings.w : settings.mw;
		}
		if (settings.maxHeight) {
			settings.mh = setSize(settings.maxHeight, 'y') - loadedHeight - interfaceHeight;
			settings.mh = settings.h && settings.h < settings.mh ? settings.h : settings.mh;
		}
		
		href = settings.href;
		
        loadingTimer = setTimeout(function () {
            jQueryloadingOverlay.show();
        }, 100);
        
		if (settings.inline) {
			// Inserts an empty placeholder where inline content is being pulled from.
			// An event is bound to put inline content back when ColorBox closes or loads new content.
			jQuerytag(div).hide().insertBefore(jQuery(href)[0]).one(event_purge, function () {
				jQuery(this).replaceWith(jQueryloaded.children());
			});
			prep(jQuery(href));
		} else if (settings.iframe) {
			// IFrame element won't be added to the DOM until it is ready to be displayed,
			// to avoid problems with DOM-ready JS that might be trying to run in that iframe.
			prep(" ");
		} else if (settings.html) {
			prep(settings.html);
		} else if (isImage(href)) {
			jQuery(photo = new Image())
			.addClass(prefix + 'Photo')
			.error(function () {
				settings.title = false;
				prep(jQuerytag(div, 'Error').text('This image could not be loaded'));
			})
			.load(function () {
				var percent;
				photo.onload = null; //stops animated gifs from firing the onload repeatedly.
				
				if (settings.scalePhotos) {
					setResize = function () {
						photo.height -= photo.height * percent;
						photo.width -= photo.width * percent;	
					};
					if (settings.mw && photo.width > settings.mw) {
						percent = (photo.width - settings.mw) / photo.width;
						setResize();
					}
					if (settings.mh && photo.height > settings.mh) {
						percent = (photo.height - settings.mh) / photo.height;
						setResize();
					}
				}
				
				if (settings.h) {
					photo.style.marginTop = Math.max(settings.h - photo.height, 0) / 2 + 'px';
				}
				
				if (jQueryrelated[1] && (settings.loop || jQueryrelated[index + 1])) {
					photo.style.cursor = 'pointer';
					photo.onclick = function () {
                        publicMethod.next();
                    };
				}
				
				if (isIE) {
					photo.style.msInterpolationMode = 'bicubic';
				}
				
				setTimeout(function () { // A pause because Chrome will sometimes report a 0 by 0 size otherwise.
					prep(photo);
				}, 1);
			});
			
			setTimeout(function () { // A pause because Opera 10.6+ will sometimes not run the onload function otherwise.
				photo.src = href;
			}, 1);
		} else if (href) {
			jQueryloadingBay.load(href, settings.data, function (data, status, xhr) {
				prep(status === 'error' ? jQuerytag(div, 'Error').text('Request unsuccessful: ' + xhr.statusText) : jQuery(this).contents());
			});
		}
	};
        
	// Navigates to the next page/image in a set.
	publicMethod.next = function () {
		if (!active && jQueryrelated[1] && (settings.loop || jQueryrelated[index + 1])) {
			index = getIndex(1);
			publicMethod.load();
		}
	};
	
	publicMethod.prev = function () {
		if (!active && jQueryrelated[1] && (settings.loop || index)) {
			index = getIndex(-1);
			publicMethod.load();
		}
	};

	// Note: to use this within an iframe use the following format: parent.jQuery.fn.colorbox.close();
	publicMethod.close = function () {
		if (open && !closing) {
			
			closing = true;
			
			open = false;
			
			trigger(event_cleanup, settings.onCleanup);
			
			jQuerywindow.unbind('.' + prefix + ' .' + event_ie6);
			
			jQueryoverlay.fadeTo(200, 0);
			
			jQuerybox.stop().fadeTo(300, 0, function () {
                 
				jQuerybox.add(jQueryoverlay).css({'opacity': 1, cursor: 'auto'}).hide();
				
				trigger(event_purge);
				
				jQueryloaded.remove();
				
				setTimeout(function () {
					closing = false;
					trigger(event_closed, settings.onClosed);
				}, 1);
			});
		}
	};

	// Removes changes ColorBox made to the document, but does not remove the plugin
	// from jQuery.
	publicMethod.remove = function () {
		jQuery([]).add(jQuerybox).add(jQueryoverlay).remove();
		jQuerybox = null;
		jQuery('.' + boxElement)
			.removeData(colorbox)
			.removeClass(boxElement)
			.die();
	};

	// A method for fetching the current element ColorBox is referencing.
	// returns a jQuery object.
	publicMethod.element = function () {
		return jQuery(element);
	};

	publicMethod.settings = defaults;

}(jQuery, document, this));