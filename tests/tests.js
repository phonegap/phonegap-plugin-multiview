
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
    });
};
