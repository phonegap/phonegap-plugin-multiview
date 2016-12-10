
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@protocol PGMultiViewDelegate <NSObject>

 - (void)dismissWithResult:(NSString*)result;

@end

@interface PGMultiViewController : CDVViewController
{
    @protected
    id <PGMultiViewDelegate> _pgmDelegate;
}

@property (nonatomic, strong) id <PGMultiViewDelegate> pgmDelegate;

@end



//PGMultiViewDelegate
@interface PGMultiView : CDVPlugin<PGMultiViewDelegate>
{
}
@property (class) NSString *msg;

@property (nonatomic, strong) PGMultiViewController* childViewController;
@property (nonatomic, strong) NSString* callbackId;


- (void)loadView:(CDVInvokedUrlCommand*)command;
- (void)dismissView:(CDVInvokedUrlCommand*)command;
- (void)getMessage:(CDVInvokedUrlCommand*)command;

- (void)dismissWithResult:(NSString*)result;


@end
