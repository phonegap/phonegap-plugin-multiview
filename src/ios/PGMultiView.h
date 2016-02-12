
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@interface PGMultiview : CDVPlugin
{}

@property (nonatomic, strong) CDVViewController* childViewController;


- (void)loadView:(CDVInvokedUrlCommand*)command;
- (void)dismissView:(CDVInvokedUrlCommand*)command;

@end