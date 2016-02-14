
#include <sys/types.h>
#include <sys/sysctl.h>
#include "TargetConditionals.h"

#import <QuartzCore/CoreAnimation.h>
#import <Cordova/CDV.h>
#import "PGMultiview.h"


@implementation PGMultiview

@synthesize childViewController;


- (void)dismissView:(CDVInvokedUrlCommand*)command
{
    [self.viewController.navigationController popViewControllerAnimated:YES];
    childViewController = NULL;

}

- (void)loadView:(CDVInvokedUrlCommand*)command
{
    childViewController = [[CDVViewController alloc] init];
    childViewController.startPage = @"index2.html"; // todo: this is a parameter
    
    if(self.viewController.navigationController == NULL)
    {
        UINavigationController* nav = [[UINavigationController alloc] init];
        nav.navigationBarHidden = YES;
        self.webView.window.rootViewController = nav;
        [nav pushViewController:self.viewController animated:NO];
    }
    
    [self.viewController.navigationController pushViewController:childViewController animated:YES];
}

@end