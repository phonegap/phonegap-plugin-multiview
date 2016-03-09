
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@interface PGMultiviewController : CDVViewController
{}
@end



@interface PGMultiview : CDVPlugin
{}

@property (nonatomic, strong) PGMultiviewController* childViewController;



- (void)loadView:(CDVInvokedUrlCommand*)command;
- (void)dismissView:(CDVInvokedUrlCommand*)command;



@end