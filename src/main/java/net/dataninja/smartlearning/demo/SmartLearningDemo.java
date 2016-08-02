/*
 * Copyright 2015 DOCOMO Innovations, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 */

package net.dataninja.smartlearning.demo;

import net.dataninja.smartlearning.client.Input;
import net.dataninja.smartlearning.client.SmartLearningApi;
import net.dataninja.smartlearning.client.SmartLearningClient;

import java.io.Console;

/**
 * A simple command demo to show how to use the Smart Learning Java APIs
 */
public class SmartLearningDemo {

    /**
     * Run through the Smart Learning APIs and show usage
     */
    public void process() {
        SmartLearningApi client = new SmartLearningClient().getClient();
        String input;

        Console cmdline = System.console();
        if (cmdline == null) {
            System.err.println("No console for command line demo.");
            System.exit(1);
        }

        // Find Smart Learning tags and query strings
        input = cmdline.readLine("Enter text to classify and find query strings: ");

        System.out.println(findSmartContentDemo(client, input).toString());
    }

    public Object findSmartContentDemo(SmartLearningApi client, String data) {
        Input input = new Input();
        input.setT(data);
        return client.processSmartLearning(input);
    }

    public static void main(String[] args) {
        SmartLearningDemo demo = new SmartLearningDemo();
        demo.process();
    }
}
