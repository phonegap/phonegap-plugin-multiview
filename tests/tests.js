
exports.defineAutoTests = function() {

    describe('PGMultiView', function () {
        it("should exist", function() {
            expect(PGMultiView).toBeDefined();
        });

        it("should have a loadView function", function() {
            expect(PGMultiView.loadView).toBeDefined();
            expect(PGMultiView.loadView).toEqual(jasmine.any(Function));
        });

        it("should have a dismissView function", function() {
            expect(PGMultiView.dismissView).toBeDefined();
            expect(PGMultiView.dismissView).toEqual(jasmine.any(Function));
        });

        it("should navigate to a child view", function() {
            var errHandler = function (err) {
                console.log("error " + err);
                expect("errorHandlerCalled").toEqual(false);
            };
            var testMessage = "hey, can this make it there and back again?";
            PGMultiView.loadView("fixtures/index2.html", testMessage, function(res) {
                console.log("success " + res);
                expect(res).toEqual(testMessage);
            },errHandler
            );
        });
    });
};
