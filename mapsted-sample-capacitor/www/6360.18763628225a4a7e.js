"use strict";(self.webpackChunkapp=self.webpackChunkapp||[]).push([[6360],{6360:(l,a,i)=>{i.r(a),i.d(a,{Geolocation:()=>u,GeolocationWeb:()=>s});var t=i(1528),c=i(6400);class s extends c.w8{getCurrentPosition(e){return(0,t.c)(function*(){return new Promise((o,r)=>{navigator.geolocation.getCurrentPosition(n=>{o(n)},n=>{r(n)},Object.assign({enableHighAccuracy:!1,timeout:1e4,maximumAge:0},e))})})()}watchPosition(e,o){return(0,t.c)(function*(){return`${navigator.geolocation.watchPosition(n=>{o(n)},n=>{o(null,n)},Object.assign({enableHighAccuracy:!1,timeout:1e4,maximumAge:0},e))}`})()}clearWatch(e){return(0,t.c)(function*(){window.navigator.geolocation.clearWatch(parseInt(e.id,10))})()}checkPermissions(){var e=this;return(0,t.c)(function*(){if(typeof navigator>"u"||!navigator.permissions)throw e.unavailable("Permissions API not available in this browser");const o=yield window.navigator.permissions.query({name:"geolocation"});return{location:o.state,coarseLocation:o.state}})()}requestPermissions(){var e=this;return(0,t.c)(function*(){throw e.unimplemented("Not implemented on web.")})()}}const u=new s}}]);