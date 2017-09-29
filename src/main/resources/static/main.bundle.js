webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".right-header{\r\n\tdisplay: inline-block;\r\n\tfloat: right;\r\n\twidth: 20%;\r\n\tcolor: white;\r\n}\r\n.header-section{\r\n\tdisplay: inline-block;\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tbackground-image: url(" + __webpack_require__("../../../../../src/assets/images/background-header.jpg") + ");;\r\n}\r\n.left-header{\r\n\tcolor: white;\r\n\theight: inherit;\r\n\twidth: 25%;\r\n\tfont-size: 27px;\r\n\tmargin: 5px;\r\n\tpadding: 7px;\r\n\tfont-family: sans-serif;\r\n\tdisplay: inline-block;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<header>\n  <div class=\"header-section\">\n    <div class=\"left-header\"><strong>SADP Trading Platform</strong></div>\n    <div class=\"right-header\">\n      <span><strong>Welcome dummy</strong></span>\n    </div>\n  </div>\n\n  <p-menubar [model]=\"items\">\n  \t\n  </p-menubar>\n</header>\n\n<router-outlet></router-outlet>\n\n<footer></footer>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent.prototype.ngOnInit = function () {
        this.items = [
            {
                label: 'View Securities',
                icon: 'fa-eye',
                routerLink: '/viewStocks'
            },
            {
                label: 'Orders',
                icon: 'fa-list',
                routerLink: '/orders'
            },
            {
                label: 'Portfolios',
                icon: 'fa-line-chart',
                routerLink: '/portfolios'
            }
        ];
    };
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html"),
        styles: [__webpack_require__("../../../../../src/app/app.component.css")]
    })
], AppComponent);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/@angular/platform-browser/animations.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_primeng_primeng__ = __webpack_require__("../../../../primeng/primeng.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_primeng_primeng___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_primeng_primeng__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__routes__ = __webpack_require__("../../../../../src/app/routes.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__components_index__ = __webpack_require__("../../../../../src/app/components/index.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};










var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["NgModule"])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_7__components_index__["c" /* ViewStocksComponent */],
            __WEBPACK_IMPORTED_MODULE_7__components_index__["b" /* PortfolioComponent */],
            __WEBPACK_IMPORTED_MODULE_7__components_index__["a" /* OrdersComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["BrowserModule"],
            __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
            __WEBPACK_IMPORTED_MODULE_3_primeng_primeng__["MenubarModule"],
            __WEBPACK_IMPORTED_MODULE_4__angular_router__["RouterModule"],
            __WEBPACK_IMPORTED_MODULE_3_primeng_primeng__["DataTableModule"],
            __WEBPACK_IMPORTED_MODULE_3_primeng_primeng__["SharedModule"],
            __WEBPACK_IMPORTED_MODULE_4__angular_router__["RouterModule"].forRoot(__WEBPACK_IMPORTED_MODULE_5__routes__["a" /* routes */]),
            __WEBPACK_IMPORTED_MODULE_3_primeng_primeng__["ChartModule"]
        ],
        providers: [],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/components/index.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__view_stocks_view_stocks_component__ = __webpack_require__("../../../../../src/app/components/view-stocks/view-stocks.component.ts");
/* harmony reexport (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return __WEBPACK_IMPORTED_MODULE_0__view_stocks_view_stocks_component__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__portfolio_portfolio_component__ = __webpack_require__("../../../../../src/app/components/portfolio/portfolio.component.ts");
/* harmony reexport (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return __WEBPACK_IMPORTED_MODULE_1__portfolio_portfolio_component__["a"]; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__orders_orders_component__ = __webpack_require__("../../../../../src/app/components/orders/orders.component.ts");
/* harmony reexport (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return __WEBPACK_IMPORTED_MODULE_2__orders_orders_component__["a"]; });



//# sourceMappingURL=index.js.map

/***/ }),

/***/ "../../../../../src/app/components/orders/orders.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/orders/orders.component.html":
/***/ (function(module, exports) {

module.exports = "<div>Orders</div>"

/***/ }),

/***/ "../../../../../src/app/components/orders/orders.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OrdersComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var OrdersComponent = (function () {
    function OrdersComponent() {
    }
    OrdersComponent.prototype.ngOnInit = function () {
    };
    return OrdersComponent;
}());
OrdersComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'orders',
        template: __webpack_require__("../../../../../src/app/components/orders/orders.component.html"),
        styles: [__webpack_require__("../../../../../src/app/components/orders/orders.component.css")]
    })
], OrdersComponent);

//# sourceMappingURL=orders.component.js.map

/***/ }),

/***/ "../../../../../src/app/components/portfolio/portfolio.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/portfolio/portfolio.component.html":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "../../../../../src/app/components/portfolio/portfolio.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PortfolioComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__domain_portfolio__ = __webpack_require__("../../../../../src/app/domain/portfolio.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__domain_order__ = __webpack_require__("../../../../../src/app/domain/order.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__domain_stock__ = __webpack_require__("../../../../../src/app/domain/stock.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var PortfolioComponent = (function () {
    function PortfolioComponent() {
        this.porfolioList = [];
        // code...
    }
    PortfolioComponent.prototype.ngOnInit = function () {
        this.initialize();
    };
    PortfolioComponent.prototype.initialize = function () {
        this.porfolioList = [new __WEBPACK_IMPORTED_MODULE_1__domain_portfolio__["a" /* Portfolio */]("Portfolio 1", [
                new __WEBPACK_IMPORTED_MODULE_2__domain_order__["a" /* Order */]("Apple 100", new __WEBPACK_IMPORTED_MODULE_3__domain_stock__["a" /* Stock */]("APPL", 12), 100, 11),
                new __WEBPACK_IMPORTED_MODULE_2__domain_order__["a" /* Order */]("Apple 200", new __WEBPACK_IMPORTED_MODULE_3__domain_stock__["a" /* Stock */]("APPL", 12), 200, 10),
                new __WEBPACK_IMPORTED_MODULE_2__domain_order__["a" /* Order */]("Apple 300", new __WEBPACK_IMPORTED_MODULE_3__domain_stock__["a" /* Stock */]("APPL", 12), 300, 12)
            ])];
    };
    return PortfolioComponent;
}());
PortfolioComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'portfolio',
        template: __webpack_require__("../../../../../src/app/components/portfolio/portfolio.component.html"),
        styles: [__webpack_require__("../../../../../src/app/components/portfolio/portfolio.component.css")]
    }),
    __metadata("design:paramtypes", [])
], PortfolioComponent);

//# sourceMappingURL=portfolio.component.js.map

/***/ }),

/***/ "../../../../../src/app/components/view-stocks/view-stocks.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "button{\r\n\twidth: 30%;\r\n\theight: 100%;\r\n\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/components/view-stocks/view-stocks.component.html":
/***/ (function(module, exports) {

module.exports = "<p-dataTable [value]=\"stockList\">\r\n    <p-column field=\"stockName\" header=\"Stock Name\"></p-column>\r\n    <p-column field=\"stockRate\" header=\"Rate\"></p-column>\r\n    <p-column styleClass=\"col-button\">\r\n        <ng-template pTemplate=\"header\">\r\n            <button type=\"button\" pButton icon=\"fa-refresh\"></button>\r\n        </ng-template>\r\n        <ng-template pTemplate=\"body\">\r\n            <button type=\"button\" pButton icon=\"fa-line-chart\"></button>\r\n        </ng-template>\r\n    </p-column>\r\n</p-dataTable>\r\n\r\n"

/***/ }),

/***/ "../../../../../src/app/components/view-stocks/view-stocks.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ViewStocksComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__domain_stock__ = __webpack_require__("../../../../../src/app/domain/stock.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};


var ViewStocksComponent = (function () {
    function ViewStocksComponent() {
        this.stockList = [];
    }
    ViewStocksComponent.prototype.ngOnInit = function () {
        this.initialize();
    };
    ViewStocksComponent.prototype.initialize = function () {
        this.stockList = [
            new __WEBPACK_IMPORTED_MODULE_1__domain_stock__["a" /* Stock */]("AAPL", 12), new __WEBPACK_IMPORTED_MODULE_1__domain_stock__["a" /* Stock */]("GOOG", 15)
        ];
    };
    return ViewStocksComponent;
}());
ViewStocksComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
        selector: 'view-stcoks',
        template: __webpack_require__("../../../../../src/app/components/view-stocks/view-stocks.component.html"),
        encapsulation: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewEncapsulation"].None,
        styles: [__webpack_require__("../../../../../src/app/components/view-stocks/view-stocks.component.css")]
    })
], ViewStocksComponent);

//# sourceMappingURL=view-stocks.component.js.map

/***/ }),

/***/ "../../../../../src/app/domain/order.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Order; });
var Order = (function () {
    function Order(orderName, stock, quotePrice, quantity) {
        this.orderName = orderName;
        this.stock = stock;
        this.quotePrice = quotePrice;
        this.quantity = quantity;
    }
    return Order;
}());

//# sourceMappingURL=order.js.map

/***/ }),

/***/ "../../../../../src/app/domain/portfolio.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Portfolio; });
var Portfolio = (function () {
    function Portfolio(portfolioName, orderList) {
        this.portfolioName = portfolioName;
        this.orderList = orderList;
    }
    return Portfolio;
}());

//# sourceMappingURL=portfolio.js.map

/***/ }),

/***/ "../../../../../src/app/domain/stock.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Stock; });
var Stock = (function () {
    function Stock(stockName, stockRate) {
        this.stockName = stockName;
        this.stockRate = stockRate;
    }
    return Stock;
}());

//# sourceMappingURL=stock.js.map

/***/ }),

/***/ "../../../../../src/app/routes.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return routes; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__components_index__ = __webpack_require__("../../../../../src/app/components/index.ts");

var routes = [
    { path: 'viewStocks', component: __WEBPACK_IMPORTED_MODULE_0__components_index__["c" /* ViewStocksComponent */] },
    { path: 'portfolios', component: __WEBPACK_IMPORTED_MODULE_0__components_index__["b" /* PortfolioComponent */] },
    { path: 'orders', component: __WEBPACK_IMPORTED_MODULE_0__components_index__["a" /* OrdersComponent */] },
    { path: '', redirectTo: 'viewStocks', pathMatch: 'full' },
    { path: '**', redirectTo: 'portfolios', pathMatch: 'full' }
];
//# sourceMappingURL=routes.js.map

/***/ }),

/***/ "../../../../../src/assets/images/background-header.jpg":
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "background-header.44f42b3c673e980d8694.jpg";

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map