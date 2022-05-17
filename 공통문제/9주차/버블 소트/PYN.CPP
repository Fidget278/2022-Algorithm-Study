#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	vector<pair<int, int>> A(N);
	int input;
	for (int i = 0; i < N; ++i) {
		cin >> A[i].first;
		A[i].second = i;
	}


	sort(A.begin(), A.end());

    int max = 0;
	for (int i = 0; i < N; ++i) {
		int step = A[i].second - i; // preIndex 에서 curIndex 빼줌
		if (max < step)
			max = step;
	}

	cout << max + 1;
	return 0;
}

