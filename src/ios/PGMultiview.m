
#include <sys/types.h>
#include <sys/sysctl.h>
#include "TargetConditionals.h"

#import <QuartzCore/CoreAnimation.h>
#import <Cordova/CDV.h>
#import "PGMultiView.h"


#pragma mark PGMultiViewController - CDVViewController subclass

@implementation PGMultiViewController

- (void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event {
    if (UIEventSubtypeMotionShake) {
        [self.navigationController popViewControllerAnimated:YES];
    }
}

// - (void)viewDidLoad
// {
//     [super viewDidLoad];
//     CGRect webViewBounds = self.view.bounds;
//     webViewBounds.origin = self.view.bounds.origin;
//     webViewBounds.origin.x = 1;
//     webViewBounds.size.width = webViewBounds.size.width - 1;
//     self.webView.bounds = webViewBounds;
// }

@end


@implementation PGMultiView

@synthesize childViewController;

- (BOOL) shouldOverrideLoadWithRequest:(NSURLRequest*)request navigationType:(UIWebViewNavigationType)navigationType
{
    return YES;
}

// TODO: override this, and use the config.xml for the currently loaded page
// also, add ALL orientations to the application
// - (BOOL)supportsOrientation:(UIInterfaceOrientation)orientation
// {
//     return [self.supportedOrientations containsObject:[NSNumber numberWithInt:orientation]];
// }

#pragma mark UINavigationControllerDelegate

- (void)navigationController:(UINavigationController *)navigationController
      willShowViewController:(UIViewController *)viewController
                    animated:(BOOL)animated
{
    if(viewController == self.viewController)
    {
        navigationController.navigationBarHidden = YES;
    }
    else
    {
        navigationController.navigationBarHidden = NO;
    }
}


#pragma mark JS Callable Plugin API

- (void)dismissView:(CDVInvokedUrlCommand*)command
{
    [self.viewController.navigationController popViewControllerAnimated:YES];
    self.viewController.navigationController.navigationBarHidden = YES;
    childViewController = NULL;
}

- (void)loadView:(CDVInvokedUrlCommand*)command
{
    childViewController = [[PGMultiViewController alloc] init];
    childViewController.startPage = [command argumentAtIndex:0];

    // TODO: set proper config.xml -> childViewController.configFile

    if(self.viewController.navigationController == NULL)
    {
        UINavigationController* nav = [[UINavigationController alloc] init];
        nav.navigationBarHidden = NO;
        nav.delegate = self;
        self.webView.window.rootViewController = nav;
        [nav pushViewController:self.viewController animated:NO];
        nav.hidesBarsOnSwipe  = YES;
        nav.hidesBarsOnTap = YES;

    }

    [self.viewController.navigationController pushViewController:childViewController animated:YES];
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end